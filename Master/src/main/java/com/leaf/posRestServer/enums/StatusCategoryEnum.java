package com.leaf.posRestServer.enums;

import com.leaf.posRestServer.utility.CommonConstant;

/**
 * @author : Rusiru on 11-Mar-18.
 */
public enum StatusCategoryEnum {

    DEFAULT(CommonConstant.STATUS_CATEGORY_DEFAULT),
    DELETE(CommonConstant.STATUS_CATEGORY_DELETE);


    private String code;

    StatusCategoryEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static StatusCategoryEnum getEnum(String code){
        switch (code){
            case CommonConstant.STATUS_CATEGORY_DEFAULT:
                return DEFAULT;
            default:
                return DELETE;
        }
    }
}
