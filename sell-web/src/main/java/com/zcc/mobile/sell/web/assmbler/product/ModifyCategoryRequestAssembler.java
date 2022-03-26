package com.zcc.mobile.sell.web.assmbler.product;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.entity.product.Category;
import com.zcc.mobile.sell.domain.entity.product.CategoryType;
import com.zcc.mobile.sell.domain.repository.product.CategoryRepository;
import com.zcc.mobile.sell.domain.repository.product.CategoryTypeRepository;
import com.zcc.mobile.sell.dto.product.command.AddCategoryTypeCommand;
import com.zcc.mobile.sell.dto.product.command.SaveCategoryCommand;
import com.zcc.mobile.sell.dto.product.command.UpdateCategoryCommand;
import com.zcc.mobile.sell.web.vo.category.AddCategoryTypeRequest;
import com.zcc.mobile.sell.web.vo.category.CategoryRequestModel;
import com.zcc.mobile.sell.web.vo.category.CategoryTypeRequestModel;
import com.zcc.mobile.sell.web.vo.category.ModifyCategoryRequest;
import org.springframework.stereotype.Component;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Component
public class ModifyCategoryRequestAssembler {
    private final CategoryRepository categoryRepository;
    private final CategoryTypeRepository categoryTypeRepository;

    public ModifyCategoryRequestAssembler(CategoryRepository categoryRepository,
                                          CategoryTypeRepository categoryTypeRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public SaveCategoryCommand toSaveCommand(ModifyCategoryRequest request) throws SellException {
        SaveCategoryCommand command = new SaveCategoryCommand();
        if (null != request && null != request.getCategory()) {
            CategoryRequestModel categoryModel = request.getCategory();
            if (categoryRepository.findByName(categoryModel.getName()).isPresent()) {
                throw new SellException("this category is not a new one");
            }
            Category category = convert(categoryModel);
            categoryTypeRepository.findByCode(categoryModel.getTypeCode())
                    .ifPresent(category::setType);
            command.setCategory(category);
        }
        return command;
    }

    public UpdateCategoryCommand toUpdateCommand(ModifyCategoryRequest request) throws SellException {
        UpdateCategoryCommand command = new UpdateCategoryCommand();
        if (null != request && null != request.getCategory()) {
            CategoryRequestModel categoryModel = request.getCategory();
            categoryRepository.findByName(categoryModel.getName())
                    .orElseThrow(() -> new SellException("can not find category"));
            Category category = convert(categoryModel);
            categoryTypeRepository.findByCode(categoryModel.getTypeCode())
                    .ifPresent(category::setType);
            command.setCategory(category);
        }
        return command;
    }

    public AddCategoryTypeCommand toAddCategoryTypeCommand(AddCategoryTypeRequest request) throws SellException {
        AddCategoryTypeCommand command = new AddCategoryTypeCommand();
        if (null != request && null != request.getCategoryType()) {
            CategoryTypeRequestModel categoryModel = request.getCategoryType();
            if (categoryTypeRepository.findByCode(categoryModel.getCode()).isPresent()) {
                throw new SellException("this type is exist");
            }
            command.setCategoryType(convert(categoryModel));
        }
        return command;
    }

    private CategoryType convert(CategoryTypeRequestModel request) {
        if (null == request) {
            return null;
        }
        CategoryType categoryType = new CategoryType();
        categoryType.setCode(request.getCode());
        categoryType.setName(request.getName());
        return categoryType;
    }

    private Category convert(CategoryRequestModel request) {
        if (null == request) {
            return null;
        }
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return category;
    }
}
