package com.zcc.mobile.sell.service.product;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.repository.product.CategoryRepository;
import com.zcc.mobile.sell.domain.repository.product.CategoryTypeRepository;
import com.zcc.mobile.sell.dto.product.CategoryDTO;
import com.zcc.mobile.sell.dto.product.CategoryTypeDTO;
import com.zcc.mobile.sell.dto.product.command.AddCategoryTypeCommand;
import com.zcc.mobile.sell.dto.product.command.SaveCategoryCommand;
import com.zcc.mobile.sell.dto.product.command.UpdateCategoryCommand;
import com.zcc.mobile.sell.mapper.product.CategoryDtoMapper;
import com.zcc.mobile.sell.mapper.product.CategoryTypeDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Devin sun
 * @date 2022/3/1
 */

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryTypeRepository categoryTypeRepository;
    private final CategoryDtoMapper categoryDtoMapper;
    private final CategoryTypeDtoMapper categoryTypeDtoMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryTypeRepository categoryTypeRepository,
                           CategoryDtoMapper categoryDtoMapper,
                           CategoryTypeDtoMapper categoryTypeDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryTypeRepository = categoryTypeRepository;
        this.categoryDtoMapper = categoryDtoMapper;
        this.categoryTypeDtoMapper = categoryTypeDtoMapper;
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.list().stream().map(categoryDtoMapper::toDto).collect(Collectors.toList());
    }

    public CategoryDTO createCategory(SaveCategoryCommand command) throws SellException {
        command.validate();
        return categoryDtoMapper.toDto(categoryRepository.save(command.getCategory()));
    }

    public CategoryDTO updateCategory(UpdateCategoryCommand command) throws SellException {
        command.validate();
        return categoryDtoMapper.toDto(categoryRepository.save(command.getCategory()));
    }

    public CategoryTypeDTO addCategoryType(AddCategoryTypeCommand command) throws SellException {
        command.validate();
        return categoryTypeDtoMapper.toDto(categoryTypeRepository.save(command.getCategoryType()));
    }
}
