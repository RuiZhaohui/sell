package com.zcc.mobile.sell.domain.repository.product;

import com.zcc.mobile.sell.domain.entity.product.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
public interface CategoryRepository {
    List<Category> list();
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Category save(Category category);
}
