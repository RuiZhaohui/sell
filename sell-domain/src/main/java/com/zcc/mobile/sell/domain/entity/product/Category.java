package com.zcc.mobile.sell.domain.entity.product;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
public class Category {

    /**
     * 主键
     */
    private long id;

    /**
     * 类型
     */
    private CategoryType type;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
}
