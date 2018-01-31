package com.leaf.posRestServer.dto;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public class CommonResponseDTO {
    private String Code;
    private String message;

    public CommonResponseDTO(String code, String message) {
        Code = code;
        this.message = message;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
