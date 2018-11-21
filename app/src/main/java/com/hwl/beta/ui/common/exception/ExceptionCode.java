package com.hwl.beta.ui.common.exception;

public enum ExceptionCode {
    IMServiceDisconnect(1, "The im service is disconnected."),
    ChatCodeUserValidateFailure(2, "Validate chat user failure"),
    ChatCodeUserBlack(3, "User is in black list");

    private String desc;
    private int index;

    ExceptionCode(int index, String desc) {
        this.desc = desc;
        this.index = index;
    }

    public static String getDesc(int index) {
        for (ExceptionCode c : ExceptionCode.values()) {
            if (c.getIndex() == index) {
                return c.desc;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
