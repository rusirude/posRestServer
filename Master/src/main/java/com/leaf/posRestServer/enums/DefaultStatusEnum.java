package com.leaf.posRestServer.enums;

import com.leaf.posRestServer.utility.CommonConstant;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public enum DefaultStatusEnum {
    ACTIVE(CommonConstant.DEFAULT_STATUS_ACTIVE),
    DEACTIVE(CommonConstant.DEFAULT_STATUS_DEACTIVE);


    private String code;

    DefaultStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DefaultStatusEnum getEnum(String code){
        switch (code){
            case CommonConstant.DEFAULT_STATUS_ACTIVE:
                return ACTIVE;
            default:
                return DEACTIVE;
        }
    }
}
