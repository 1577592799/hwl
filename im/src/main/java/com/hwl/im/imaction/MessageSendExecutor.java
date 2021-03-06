package com.hwl.im.imaction;

import com.hwl.imcore.improto.ImMessageContext;
import com.hwl.imcore.improto.ImMessageType;

public interface MessageSendExecutor {

    ImMessageType getMessageType();

    ImMessageContext getMessageContext();

    void sendResultCallback(boolean isSuccess);

    boolean isSendFailedAndClose();
}