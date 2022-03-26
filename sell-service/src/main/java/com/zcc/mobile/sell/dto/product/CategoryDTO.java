package com.zcc.mobile.sell.dto.product;

import com.zcc.mobile.sell.po.product.CategoryTypePO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 4573456456L;

    private String name;

    private String description;

    private CategoryTypeDTO type;
}
