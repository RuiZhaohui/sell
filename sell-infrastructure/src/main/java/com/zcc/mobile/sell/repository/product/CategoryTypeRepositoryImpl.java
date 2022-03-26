package com.zcc.mobile.sell.repository.product;

import com.zcc.mobile.sell.domain.entity.product.CategoryType;
import com.zcc.mobile.sell.domain.repository.product.CategoryTypeRepository;
import com.zcc.mobile.sell.mapper.product.CategoryTypePoMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Repository
public class CategoryTypeRepositoryImpl implements CategoryTypeRepository {
    private final CategoryTypePoRepository categoryTypePoRepository;
    private final CategoryTypePoMapper categoryTypePoMapper;

    public CategoryTypeRepositoryImpl(CategoryTypePoRepository categoryTypePoRepository,
                                      CategoryTypePoMapper categoryTypePoMapper) {
        this.categoryTypePoRepository = categoryTypePoRepository;
        this.categoryTypePoMapper = categoryTypePoMapper;
    }

    @Override
    public Optional<CategoryType> findByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return Optional.empty();
        }
        return categoryTypePoRepository.findByCode(code).map(categoryTypePoMapper::toEntity);
    }

    @Override
    public CategoryType save(CategoryType categoryType) {
        if (null == categoryType) {
            return null;
        }
        return categoryTypePoMapper.toEntity(categoryTypePoRepository.save(categoryTypePoMapper.toPo(categoryType)));
    }
}
