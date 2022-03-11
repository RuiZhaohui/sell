package com.zcc.mobile.sell.domain.model.vo.category;

import lombok.Data;

import java.util.Date;

/**
 * @author Devin sun
 * @date 2022/3/1
 */
@Data
public class CategoryInfoVO {

    private Long id;
    private Integer type;
    private String name;
    private String description;
    private Date createTime;
    private Date updateTime;
}
