package com.hwl.im.imaction;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.hwl.im.immode.MessageRequestHeadOperate;
import com.hwl.im.immode.RequestSessionInvalidException;
import com.hwl.imcore.improto.ImMessageContext;
import com.hwl.imcore.improto.ImMessageRequestHead;
import com.hwl.imcore.improto.ImMessageResponse;
import com.hwl.imcore.improto.ImMessageResponseCode;
import com.hwl.imcore.improto.ImMessageResponseHead;

import io.netty.channel.Channel;

public abstract class AbstractMessageReceivExecutor<TRequest> implements MessageReceiveExecutor {
//    private static Logger log = LogManager.getLogger(AbstractMessageReceivExecutor.class.getName());

    protected ImMessageRequestHead requestHead;
    protected TRequest request;
    protected Channel channel;

    public AbstractMessageReceivExecutor(TRequest request) {
        this.request = request;
    }

    protected void checkRequestParams() {
        if (this.requestHead == null) {
            throw new NullPointerException("requestHead");
        }
        if (this.request == null) {
            throw new NullPointerException("request");
        }
        if (this.isCheckSessionid() && !MessageRequestHeadOperate.isSessionValid(this.requestHead)) {
            throw new RequestSessionInvalidException("sessionid is invalid");
        }
    }

    @Override
    public final void setRequestHead(ImMessageRequestHead requestHead) {
        this.requestHead = requestHead;
    }

    @Override
    public final void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public final ImMessageContext execute() {
        ImMessageResponseHead.Builder responseHead = ImMessageResponseHead.newBuilder();
        responseHead.setCode(ImMessageResponseCode.Success_VALUE).setMessage("");

        ImMessageResponse.Builder msgResponse = ImMessageResponse.newBuilder().setResponseHead(responseHead);

        try {
            this.checkRequestParams();
            this.executeCore(msgResponse);
        } catch (RequestSessionInvalidException e) {
//            log.error("Server executor : {}", e.getMessage());
            responseHead.setCode(ImMessageResponseCode.SessionInvalid_VALUE).setMessage(e.getMessage());
        } catch (Exception e) {
//            log.error("Server executor : {}", e.getMessage());
            responseHead.setCode(ImMessageResponseCode.Failed_VALUE).setMessage(e.getMessage());
        }

        if (this.isResponseNull()) {
            return null;
        }

        return this.getMessageContext(msgResponse);
    }

    protected ImMessageContext getMessageContext(ImMessageResponse.Builder response) {
        return ImMessageContext.newBuilder().setResponse(response).setType(getMessageType()).build();
    }

    public boolean isResponseNull() {
        return true;
    }

    public boolean isCheckSessionid() {
        return true;
    }

    public abstract void executeCore(final ImMessageResponse.Builder response);
}