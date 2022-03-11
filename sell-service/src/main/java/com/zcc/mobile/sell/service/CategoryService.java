package com.zcc.mobile.sell.service;

import com.zcc.mobile.sell.domain.dao.CategoryDao;
import com.zcc.mobile.sell.domain.model.vo.category.CategoryInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Devin sun
 * @date 2022/3/1
 */

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<CategoryInfoVO> getAllCategory() {

    }
}
