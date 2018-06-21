package com.tcredit.uniqueIdSystem.common;

public enum ErrorCode {


    SUCCESS("请求成功", "200"),
    ERROR("系统繁忙", "400"),
    PARAMETER_ERROR("参数错误", "401"),
    CARDNO__ERROR("身份证验证失败", "402");

    private String msg;
    private String msgCode;

    private ErrorCode(String msg, String msgCode) {
        this.msg = msg;
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getMsgCode() {
        return this.msgCode;
    }
}
