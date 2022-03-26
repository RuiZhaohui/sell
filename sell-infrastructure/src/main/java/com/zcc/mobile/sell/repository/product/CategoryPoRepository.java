package com.zcc.mobile.sell.repository.product;

import com.zcc.mobile.sell.po.product.CategoryPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Repository
public interface CategoryPoRepository extends JpaRepository<CategoryPO, Long> {
    Optional<CategoryPO> findByName(String name);
}
