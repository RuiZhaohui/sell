package com.zcc.mobile.sell.repository.product;

import com.zcc.mobile.sell.po.product.CategoryTypePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Repository
public interface CategoryTypePoRepository extends JpaRepository<CategoryTypePO, Long> {
    Optional<CategoryTypePO> findByCode(String code);
}
