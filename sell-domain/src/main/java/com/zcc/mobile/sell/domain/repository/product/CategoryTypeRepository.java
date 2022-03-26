package com.zcc.mobile.sell.domain.repository.product;

import com.zcc.mobile.sell.domain.entity.product.CategoryType;

import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
public interface CategoryTypeRepository {
    Optional<CategoryType> findByCode(String code);
    CategoryType save(CategoryType categoryType);
}
