package com.zcc.mobile.sell.mapper.product;

import com.zcc.mobile.sell.domain.entity.product.CategoryType;
import com.zcc.mobile.sell.po.product.CategoryTypePO;
import org.mapstruct.Mapper;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Mapper(componentModel = "spring")
public interface CategoryTypePoMapper {
    CategoryType toEntity(CategoryTypePO po);

    CategoryTypePO toPo(CategoryType categoryType);
}
