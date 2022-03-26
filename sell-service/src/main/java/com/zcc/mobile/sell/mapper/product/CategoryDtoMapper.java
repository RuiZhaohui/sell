package com.zcc.mobile.sell.mapper.product;

import com.zcc.mobile.sell.domain.entity.product.Category;
import com.zcc.mobile.sell.dto.product.CategoryDTO;
import org.mapstruct.Mapper;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Mapper(componentModel = "spring", uses = {CategoryTypeDtoMapper.class})
public interface CategoryDtoMapper {
    CategoryDTO toDto(Category category);
}
