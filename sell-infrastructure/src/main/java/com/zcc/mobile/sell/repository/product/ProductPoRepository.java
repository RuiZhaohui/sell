package com.zcc.mobile.sell.repository.product;

import com.zcc.mobile.sell.domain.entity.product.Product;
import com.zcc.mobile.sell.po.product.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Repository
public interface ProductPoRepository extends JpaRepository<ProductPO, Long>,
        PagingAndSortingRepository<ProductPO, Long> {
    Optional<ProductPO> findByCode(String code);
}
