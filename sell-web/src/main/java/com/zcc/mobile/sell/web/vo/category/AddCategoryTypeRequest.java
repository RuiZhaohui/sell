package com.zcc.mobile.sell.web.vo.category;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class AddCategoryTypeRequest {
    @NotNull(message = "type can not be null")
    CategoryTypeRequestModel categoryType;
}
