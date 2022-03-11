package com.zcc.mobile.sell.domain.enums;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
public enum ResponseResultEnum {
    NA(-1, "未知"),

    /**
     * 用户信息错误
     */
    USER_INFO_ERROR(-1, "用户信息为空");

    private int code;
    private String message;

    ResponseResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
