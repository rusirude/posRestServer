package com.leaf.posRestServer.enums;

import com.leaf.posRestServer.utility.CommonConstant;

/**
 * @author : Rusiru on 31-Jan-18.
 */public enum DeleteStatusEnum {

    DELETE(CommonConstant.STATUS_CATEGORY_DELETE);


    private String code;

    DeleteStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DeleteStatusEnum getEnum(String code){
        switch (code){
            case CommonConstant.STATUS_CATEGORY_DELETE:
                return DELETE;
            default:
                return null;
        }
    }
}
