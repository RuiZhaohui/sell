package com.zcc.mobile.sell.web.controller;

import com.zcc.mobile.sell.common.constant.RestConstant;
import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.dto.product.CategoryDTO;
import com.zcc.mobile.sell.service.product.CategoryService;
import com.zcc.mobile.sell.web.assmbler.product.ModifyCategoryRequestAssembler;
import com.zcc.mobile.sell.web.vo.SellResponse;
import com.zcc.mobile.sell.web.vo.SuccessSellResponse;
import com.zcc.mobile.sell.web.vo.category.AddCategoryTypeRequest;
import com.zcc.mobile.sell.web.vo.category.ModifyCategoryRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Devin sun
 * @date 2022/3/1
 */
@RestController
@RequestMapping(value = RestConstant.REST_PREFIX + RestConstant.CATEGORY_MODULE)
public class CategoryController {
    private final CategoryService categoryService;
    private final ModifyCategoryRequestAssembler modifyCategoryRequestAssembler;

    public CategoryController(CategoryService categoryService, ModifyCategoryRequestAssembler modifyCategoryRequestAssembler) {
        this.categoryService = categoryService;
        this.modifyCategoryRequestAssembler = modifyCategoryRequestAssembler;
    }

    @GetMapping(RestConstant.LIST)
    public SellResponse<List<CategoryDTO>> getCategoryList() {
        return SuccessSellResponse.of(categoryService.getAllCategory());
    }

    @PostMapping(RestConstant.CREATE)
    public SellResponse<Boolean> createCategory(@RequestBody @Validated ModifyCategoryRequest request) throws SellException {
        categoryService.createCategory(modifyCategoryRequestAssembler.toSaveCommand(request));
        return SuccessSellResponse.of(Boolean.TRUE);
    }

    @PostMapping(RestConstant.UPDATE)
    public SellResponse<Boolean> updateCategory(@RequestBody @Validated ModifyCategoryRequest request) throws SellException {
        categoryService.updateCategory(modifyCategoryRequestAssembler.toUpdateCommand(request));
        return SuccessSellResponse.of(Boolean.TRUE);
    }

    @PostMapping("/type/add")
    public SellResponse<Boolean> addCategoryType(@RequestBody @Validated AddCategoryTypeRequest request) throws SellException {
        categoryService.addCategoryType(modifyCategoryRequestAssembler.toAddCategoryTypeCommand(request));
        return SuccessSellResponse.of(Boolean.TRUE);
    }
}
