package com.tcredit.uniqueIdSystem.pojo.model;

import com.tcredit.uniqueIdSystem.common.ErrorCode;

/**
 * Created by renkuo.zhao on 2016/10/12.
 */
public class ResponseModel {
    private String code;
    private String message;
    private String uniqueId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setCodeMessage(ErrorCode errorCode) {
        this.code=errorCode.getMsgCode();
        this.message = errorCode.getMsg();
    }

}
