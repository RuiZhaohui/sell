package com.zcc.mobile.sell.repository.product;

import com.zcc.mobile.sell.domain.entity.product.Category;
import com.zcc.mobile.sell.domain.repository.product.CategoryRepository;
import com.zcc.mobile.sell.mapper.product.CategoryPoMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryPoRepository categoryPoRepository;
    private final CategoryPoMapper categoryPoMapper;

    public CategoryRepositoryImpl(CategoryPoRepository categoryPoRepository, CategoryPoMapper categoryPoMapper) {
        this.categoryPoRepository = categoryPoRepository;
        this.categoryPoMapper = categoryPoMapper;
    }

    @Override
    public List<Category> list() {
        return categoryPoRepository.findAll().stream().map(categoryPoMapper::toEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        if (null == id) {
            return Optional.empty();
        }
        return categoryPoRepository.findById(id).map(categoryPoMapper::toEntity);
    }

    @Override
    public Optional<Category> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Optional.empty();
        }
        return categoryPoRepository.findByName(name).map(categoryPoMapper::toEntity);
    }

    @Override
    public Category save(Category category) {
        if (null == category) {
            return null;
        }
        return categoryPoMapper.toEntity(categoryPoRepository.save(categoryPoMapper.toPo(category)));
    }
}
