package com.zcc.mobile.sell.web.controller;

import com.zcc.mobile.sell.common.constant.RestConstant;
import com.zcc.mobile.sell.domain.model.vo.SellResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devin sun
 * @date 2022/3/1
 */
@RestController
@RequestMapping(value = RestConstant.REST_PREFIX + RestConstant.CATEGORY_MODULE,
        produces = "application/json;charset=utf-8")
public class CategoryController {

    @GetMapping(RestConstant.LIST)
    public SellResponse getCategoryList() {
        try {

        }catch (Exception e){

        }
    }

}
