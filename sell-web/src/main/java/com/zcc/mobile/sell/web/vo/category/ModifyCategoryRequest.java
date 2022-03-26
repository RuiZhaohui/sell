package com.zcc.mobile.sell.web.vo.category;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class ModifyCategoryRequest {
    @NotNull(message = "category can not be null")
    @Valid
    private CategoryRequestModel category;
}
