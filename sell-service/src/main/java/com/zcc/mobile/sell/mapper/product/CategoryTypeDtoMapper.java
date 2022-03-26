package com.zcc.mobile.sell.mapper.product;

import com.zcc.mobile.sell.domain.entity.product.CategoryType;
import com.zcc.mobile.sell.dto.product.CategoryTypeDTO;
import org.mapstruct.Mapper;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Mapper(componentModel = "spring")
public interface CategoryTypeDtoMapper {
    CategoryTypeDTO toDto(CategoryType categoryType);
}
