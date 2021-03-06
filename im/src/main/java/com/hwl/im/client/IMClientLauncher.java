package com.hwl.im.client;

import com.hwl.imcore.improto.ImMessageContext;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class IMClientLauncher {
//    static Logger log = LogManager.getLogger(IMClientLauncher.class.getName());

    public static final int STATUS_DISCONNECT = 0;
    public static final int STATUS_CONNECT = 1;

    private String host;
    private int port;
    private int status = STATUS_DISCONNECT;// 0:disconnect 1:connect

    private EventLoopGroup workGroup;
    private Bootstrap bootstrap;
    private Channel channel;
    private IMClientListener clientListener;
    private ClientMessageOperate messageOperate;

    public IMClientLauncher(String host, int port) {
        this.host = host;
        this.port = port;
        this.clientListener = new DefaultClientListener();

        init();
    }

    public void registerClientListener(IMClientListener clientListener) {
        if (clientListener != null)
            this.clientListener = clientListener;
    }

    public void registerAction(ClientMessageOperate messageOperate) {
        this.messageOperate = messageOperate;
    }

    private void registerChannel() {
        if (this.messageOperate != null) {
            this.messageOperate.registerChannel(channel);
            this.messageOperate.registerDisconnectCallback(new Runnable() {
                @Override
                public void run() {
                    resetStatus();
                }
            });
        }
    }

    public String getServerAddress() {
        return String.format("%s:%d", host, port);
    }

    private void init() {
        workGroup = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(workGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new ProtobufVarint32FrameDecoder());
                pipeline.addLast(new ProtobufDecoder(ImMessageContext.getDefaultInstance()));
                pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                pipeline.addLast(new ProtobufEncoder());

                pipeline.addLast(new ClientMessageChannelHandler(messageOperate, clientListener));
            }
        });
    }

    public void connect() {
        if (channel != null) {
            init();
        }
        connectServer();
    }

    private void connectServer() {
        if (status == STATUS_CONNECT)
            return;

        try {
            final ChannelFuture channelFuture = bootstrap.connect(host, port);//.sync();
            channelFuture.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture f) {
                    if (f.isSuccess()) {
                        status = STATUS_CONNECT;
                        channel = channelFuture.channel();
                        registerChannel();
                        clientListener.onBuildConnectionSuccess(getServerAddress());
                    } else {
                        //throw new Exception("build connection failure");
                        clientListener.onBuildConnectionError(getServerAddress(), "build connection failure");
                        status = STATUS_DISCONNECT;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            this.clientListener.onBuildConnectionError(this.getServerAddress(), e.getMessage());
            status = STATUS_DISCONNECT;
            stop();
        }
    }

    public void stop() {
        if (!isConnected()) return;
        if (channel != null) {
            try {
                channel.close();//.sync();
                resetStatus();
                // log.info("Client disconnect {} success...", channel.remoteAddress());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (workGroup != null) {
            workGroup.shutdownGracefully();
        }
        this.clientListener.onClosed(this.getServerAddress());
    }

    public boolean isConnected() {
        if (status == STATUS_CONNECT)
            return true;
        return false;
    }

    public int getStatus() {
        return status;
    }

    public void resetStatus() {
        status = STATUS_DISCONNECT;
    }

    private class DefaultClientListener implements IMClientListener {

        @Override
        public void onBuildConnectionSuccess(String serverAddress) {
//            log.info("Client {} connected to server {} successfully.", clientAddress,
// serverAddress);
        }

        @Override
        public void onBuildConnectionError(String serverAddress, String
                errorInfo) {
//            log.info("Client {} connected to server {} failure. info :", clientAddress,
// serverAddress, errorInfo);
        }

        @Override
        public void onClosed(String clientAddress) {

//            log.info("Client {} closed", clientAddress);
        }

        @Override
        public void onDisconnected(String clientAddress) {
//            log.info("Client {} disconnect", clientAddress);
        }

        @Override
        public void onError(String clientAddress, String errorInfo) {
//            log.info("An error occurred on the client {}. info : {}", clientAddress, errorInfo);
        }

    }
}
