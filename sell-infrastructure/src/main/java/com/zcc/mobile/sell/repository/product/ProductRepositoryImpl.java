package com.zcc.mobile.sell.repository.product;

import com.google.common.collect.Lists;
import com.zcc.mobile.sell.domain.entity.product.Category;
import com.zcc.mobile.sell.domain.entity.product.Product;
import com.zcc.mobile.sell.domain.repository.product.ProductRepository;
import com.zcc.mobile.sell.mapper.product.CategoryPoMapper;
import com.zcc.mobile.sell.mapper.product.ProductPoMapper;
import com.zcc.mobile.sell.po.product.CategoryPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductPoRepository productPoRepository;
    private final CategoryPoRepository categoryPoRepository;
    private final ProductPoMapper productPoMapper;

    public ProductRepositoryImpl(ProductPoRepository productPoRepository,
                                 CategoryPoRepository categoryPoRepository,
                                 ProductPoMapper productPoMapper) {
        this.productPoRepository = productPoRepository;
        this.categoryPoRepository = categoryPoRepository;
        this.productPoMapper = productPoMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Product> listProducts() {
        return productPoRepository.findAll().stream().map(productPoMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Product> listProducts(Pageable pageable) {
        if (null == pageable) {
            return Page.empty();
        }
        return productPoRepository.findAll(pageable).map(productPoMapper::toEntity);
    }

    @Override
    public List<Product> listProducts(Long categoryId) {
        if (null == categoryId) {
            return Collections.emptyList();
        }
        return categoryPoRepository.findById(categoryId).map(CategoryPO::getProducts)
                .orElse(Lists.newArrayList()).stream().map(productPoMapper::toEntity).collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        if (null == product) {
            return null;
        }
        return productPoMapper.toEntity(productPoRepository.save(productPoMapper.toPo(product)));
    }

    @Override
    public Optional<Product> findByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return Optional.empty();
        }
        return productPoRepository.findByCode(code).map(productPoMapper::toEntity);
    }
}
