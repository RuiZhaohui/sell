package com.zcc.mobile.sell.web.vo;

import com.zcc.mobile.sell.web.enums.ResponseStatusEnum;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
public class SuccessSellResponse<T> extends SellResponse<T> {
    private SuccessSellResponse(T data) {
        super(ResponseStatusEnum.SUCCESS.getCode(), null, data);
    }

    public static <T> SuccessSellResponse<T> of(T data) {
        return new SuccessSellResponse<>(data);
    }
}
