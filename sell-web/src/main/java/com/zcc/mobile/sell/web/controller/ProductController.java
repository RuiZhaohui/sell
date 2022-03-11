package com.zcc.mobile.sell.web.controller;

import com.zcc.mobile.sell.common.constant.RestConstant;
import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.enums.ResponseStatusEnum;
import com.zcc.mobile.sell.domain.model.vo.SellResponse;
import com.zcc.mobile.sell.domain.model.vo.product.ModifyProductRequest;
import com.zcc.mobile.sell.domain.model.vo.product.ProductInfoVO;
import com.zcc.mobile.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@RestController
@RequestMapping(value = RestConstant.REST_PREFIX + RestConstant.PRODUCT_MODULE,
        produces = "application/json;charset=utf-8")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(RestConstant.LIST)
    public SellResponse getProductList() {
        try {
            List<ProductInfoVO> list = productService.getProductList();
            return SellResponse.newBuilder()
                    .setData(list)
                    .build();
        } catch (Exception e) {
            if (e instanceof SellException) {
                log.error("get product list error", e);
                return SellResponse.newBuilder()
                        .setCode(ResponseStatusEnum.FAILURE.getCode())
                        .setMessage("get product list failed!")
                        .build();
            } else {
                e.printStackTrace();
                return SellResponse.newBuilder()
                        .setCode(ResponseStatusEnum.FAILURE.getCode())
                        .setMessage(ResponseStatusEnum.FAILURE.getMessage())
                        .build();
            }
        }
    }

    @PostMapping(RestConstant.CREATE)
    public SellResponse createNewProduct(@RequestBody ModifyProductRequest request) {
        if (Objects.isNull(request)
                || StringUtils.isEmpty(request.getAccount())) {
            return SellResponse.newBuilder()
                    .setCode(ResponseStatusEnum.FAILURE.getCode())
                    .setMessage("Please Login First!")
                    .setData(false)
                    .build();
        }
        try {
            productService.createProduct(request);
            return SellResponse.newBuilder()
                    .setData(true)
                    .build();
        } catch (Exception e) {
            if (e instanceof SellException) {
                return SellResponse.newBuilder()
                        .setCode(ResponseStatusEnum.FAILURE.getCode())
                        .setMessage("create product failed!")
                        .build();
            } else {
                log.error("create product error", e);
                return SellResponse.newBuilder()
                        .setCode(ResponseStatusEnum.FAILURE.getCode())
                        .setMessage(ResponseStatusEnum.FAILURE.getMessage())
                        .build();
            }
        }
    }

    @PostMapping(RestConstant.UPDATE)
    public SellResponse updateProduct(@RequestBody ModifyProductRequest request) {
        if (Objects.isNull(request)
                || StringUtils.isEmpty(request.getAccount())) {
            return SellResponse.newBuilder()
                    .setCode(ResponseStatusEnum.FAILURE.getCode())
                    .setMessage("Please Login First!")
                    .setData(false)
                    .build();
        }
        try {
            productService.updateProduct(request);
            return SellResponse.newBuilder()
                    .setData(true)
                    .build();
        } catch (Exception e) {
            if (e instanceof SellException) {
                return SellResponse.newBuilder()
                        .setCode(ResponseStatusEnum.FAILURE.getCode())
                        .setMessage("create product failed!")
                        .build();
            } else {
                log.error("create product error", e);
                return SellResponse.newBuilder()
                        .setCode(ResponseStatusEnum.FAILURE.getCode())
                        .setMessage(ResponseStatusEnum.FAILURE.getMessage())
                        .build();
            }
        }
    }
}