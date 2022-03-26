package com.zcc.mobile.sell.domain.repository.product;

import com.zcc.mobile.sell.domain.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
public interface ProductRepository {
    List<Product> listProducts();
    Page<Product> listProducts(Pageable pageable);
    List<Product> listProducts(Long categoryId);
    Product save(Product product);
    Optional<Product> findByCode(String code);
}
