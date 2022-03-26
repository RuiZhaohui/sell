package com.zcc.mobile.sell.web.vo;

import lombok.Data;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
public abstract class AbstractRequest {

    private String openId;
    private String account;
}
