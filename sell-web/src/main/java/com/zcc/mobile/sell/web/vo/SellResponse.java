package com.zcc.mobile.sell.web.vo;


import com.zcc.mobile.sell.web.enums.ResponseStatusEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Getter
public class SellResponse<T> implements Serializable {
    private static final long serialVersionUID = 3546232543245L;

    private final Integer code;
    private final String message;
    private final T data;

    protected SellResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }



    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public final static class Builder<T> {
        private Integer code;
        private String message;
        private T data;

        private Builder() {
            this.code = ResponseStatusEnum.SUCCESS.getCode();
            this.message = ResponseStatusEnum.FAILURE.getMessage();
            this.data = null;
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public SellResponse<T> build() {
            return new SellResponse<>(code, message, data);
        }
    }

}
