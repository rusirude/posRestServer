package com.leaf.posRestServer.enums;

import com.leaf.posRestServer.utility.CommomConstant;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public enum DefaultStatusEnum {
    ACTIVE(CommomConstant.DEFAULT_STATUS_ACTIVE),
    DEACTIVE(CommomConstant.DEFAULT_STATUS_DEACTIVE),
    DELETE(CommomConstant.DEFAULT_STATUS_DELETE);

    private String code;

    DefaultStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DefaultStatusEnum getEnum(String code){
        switch (code){
            case CommomConstant.DEFAULT_STATUS_ACTIVE:
                return ACTIVE;
            case CommomConstant.DEFAULT_STATUS_DEACTIVE:
                return DEACTIVE;
            default:
                return DELETE;
        }
    }
}
