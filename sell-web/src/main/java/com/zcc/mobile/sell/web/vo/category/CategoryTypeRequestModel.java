package com.zcc.mobile.sell.web.vo.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class CategoryTypeRequestModel {
    @NotBlank(message = "code can not be null")
    private String code;
    @NotBlank(message = "name can not be null")
    private String name;
}
