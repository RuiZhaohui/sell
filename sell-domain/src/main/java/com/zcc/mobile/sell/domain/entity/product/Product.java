package com.zcc.mobile.sell.domain.entity.product;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
public class Product {
    /**
     * 主键
     */
    private long id;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片
     */
    private String image;

    /**
     * 分类
     */
    private Category category;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private int stock;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
}
