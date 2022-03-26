package com.zcc.mobile.sell.web.controller;

import com.zcc.mobile.sell.common.constant.RestConstant;
import com.zcc.mobile.sell.dto.product.ProductDTO;
import com.zcc.mobile.sell.web.assmbler.product.ModifyProductRequestAssembler;
import com.zcc.mobile.sell.web.vo.SellResponse;
import com.zcc.mobile.sell.web.vo.SuccessSellResponse;
import com.zcc.mobile.sell.web.vo.product.ModifyProductRequest;
import com.zcc.mobile.sell.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@RestController
@RequestMapping(value = RestConstant.REST_PREFIX + RestConstant.PRODUCT_MODULE)
@Slf4j
public class ProductController {
    private final ProductService productService;
    private final ModifyProductRequestAssembler modifyProductRequestAssembler;

    public ProductController(ProductService productService, ModifyProductRequestAssembler modifyProductRequestAssembler) {
        this.productService = productService;
        this.modifyProductRequestAssembler = modifyProductRequestAssembler;
    }

    @GetMapping(RestConstant.LIST)
    public SellResponse<List<ProductDTO>> getProductList() {
        return SuccessSellResponse.of(productService.getProductList());
    }

    @GetMapping(RestConstant.PAGE)
    public SellResponse<Page<ProductDTO>> getProductList(@RequestParam @NotNull Integer page, @NotNull Integer size) {
        return SuccessSellResponse.of(productService.getProductList(PageRequest.of(page, size)));
    }

    @PostMapping(RestConstant.CREATE)
    public SellResponse<Boolean> createNewProduct(@RequestBody @Validated ModifyProductRequest request) throws Exception {
        productService.createProduct(modifyProductRequestAssembler.toSaveProductCommand(request));
        return SuccessSellResponse.of(true);
    }

    @PostMapping(RestConstant.UPDATE)
    public SellResponse<Boolean> updateProduct(@RequestBody @Validated ModifyProductRequest request) throws Exception {
        productService.updateProduct(modifyProductRequestAssembler.toUpdateProductCommand(request));
        return SuccessSellResponse.of(true);
    }
}
