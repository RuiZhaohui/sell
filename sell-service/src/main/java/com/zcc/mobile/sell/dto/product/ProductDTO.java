package com.zcc.mobile.sell.dto.product;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 54363425325L;

    private String code;
    private String name;
    private String description;
    private String img;
    private BigDecimal price;
    private Integer stock;
    private CategoryDTO category;
}
