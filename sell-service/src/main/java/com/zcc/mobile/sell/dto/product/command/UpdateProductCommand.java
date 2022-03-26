package com.zcc.mobile.sell.dto.product.command;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.entity.product.Product;
import lombok.Data;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class UpdateProductCommand {
    private Product product;

    public void validate() throws SellException {
        if (null == product) {
            throw new SellException("the product to update can not be null");
        }
        if (null == product.getCode()) {
            throw new SellException("the product has none code");
        }
    }
}
