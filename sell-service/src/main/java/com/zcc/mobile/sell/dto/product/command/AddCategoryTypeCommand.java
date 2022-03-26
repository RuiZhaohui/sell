package com.zcc.mobile.sell.dto.product.command;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.entity.product.CategoryType;
import lombok.Data;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class AddCategoryTypeCommand {
    private CategoryType categoryType;

    public void validate() throws SellException {

    }
}
