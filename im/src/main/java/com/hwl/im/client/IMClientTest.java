package com.hwl.im.client;

// import com.hwl.beta.ui.immsg.listen.ChatGroupMessageListen;
// import com.hwl.beta.ui.immsg.listen.ChatUserMessageListen;
// import com.hwl.beta.ui.immsg.listen.UserValidateListen;
// import com.hwl.beta.ui.immsg.send.ChatGroupMessageSend;
// import com.hwl.beta.ui.immsg.send.ChatUserMessageSend;
// import com.hwl.beta.ui.immsg.send.HeartBeatMessageSend;
// import com.hwl.beta.ui.immsg.send.UserValidateSend;
// import com.hwl.im.core.immode.MessageRequestHeadOperate;
// import com.hwl.im.core.proto.ImMessageType;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.TimerTask;

import com.hwl.im.imaction.AbstractMessageSendExecutor;
import com.hwl.im.imaction.MessageListenExecutor;

public class IMClientTest {

    public void send(ClientMessageOperate messageOperate, AbstractMessageSendExecutor sendExecutor,
            MessageListenExecutor listenExecutor) {
        messageOperate.send(sendExecutor, listenExecutor);
    }

    // static Logger log = LogManager.getLogger(IMClientTest.class.getName());

    // public static void main(String[] args) throws Exception {
    // ClientMessageOperate messageOperate = new ClientMessageOperate();

    // IMClientLauncher launcher = new IMClientLauncher("127.0.0.1", 8081);
    // launcher.registerAction(messageOperate);
    // launcher.connect();

    // messageOperate.registerListenExecutor(ImMessageType.ChatUser, new
    // ChatUserMessageListen());
    // messageOperate.registerListenExecutor(ImMessageType.ChatGroup, new
    // ChatGroupMessageListen());

    // messageOperate.send(new UserValidateSend(10000L, "123456"), new
    // UserValidateListen((sessionid) -> {
    // MessageRequestHeadOperate.setSessionid(sessionid);
    // IMClientHeartbeatTimer.getInstance().run(new TimerTask() {
    // @Override
    // public void run() {
    // messageOperate.send(new HeartBeatMessageSend());
    // }
    // });
    // return null;
    // }));

    // while (true) {
    // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // String inputText = reader.readLine();
    // if (inputText.equals("cums1")) {
    // messageOperate.send(new ChatUserMessageSend(1, 2, "Hello world!"));
    // } else if (inputText.equals("cums2")) {
    // messageOperate.send(new ChatUserMessageSend(1, 3, "How are you!"));
    // } else if (inputText.equals("cgms1")) {
    // messageOperate.send(new ChatGroupMessageSend(1, "chat-group-guid-1", "I want
    // into this group"));
    // } else if (inputText.equals("cgms2")) {
    // messageOperate.send(new ChatGroupMessageSend(1, "chat-group-guid-1", "yes or
    // no !"));
    // } else if (inputText.equals("hbms")) {
    // messageOperate.send(new HeartBeatMessageSend());
    // } else if (inputText.equals("conn")) {
    // launcher.connect();
    // } else {
    // System.out.println("None command");
    // }
    // }
    // }

}