package com.zcc.mobile.sell.domain.dao;

import com.zcc.mobile.sell.domain.entity.CategoryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Devin sun
 * @date 2022/3/1
 */
@Mapper
public interface CategoryDao {


    @Select("select * from category_info where status = #{status}")
    @Results({
            @Result(column = "", property = "")
    })
    List<CategoryEntity> findAll(@Param("status") int status);
}
