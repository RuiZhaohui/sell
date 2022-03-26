package com.zcc.mobile.sell.mapper.product;

import com.zcc.mobile.sell.domain.entity.product.Category;
import com.zcc.mobile.sell.po.product.CategoryPO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Mapper(componentModel = "spring", uses = {CategoryTypePoMapper.class})
public interface CategoryPoMapper {
    Category toEntity(CategoryPO po);

    CategoryPO toPo(Category category);
}
