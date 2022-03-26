package com.zcc.mobile.sell.web.enums;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
public enum ResponseStatusEnum {
    /**
     * 未知
     */
    NA(100010, "NA"),

    /**
     * 成功
     */
    SUCCESS(100000, "Success"),

    /**
     * 失败
     */
    FAILURE(100001, "Failure");


    private int code;
    private String message;

    ResponseStatusEnum(int code, String message) {
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

