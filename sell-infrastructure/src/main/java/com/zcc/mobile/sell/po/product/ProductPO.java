package com.zcc.mobile.sell.po.product;

import com.zcc.mobile.sell.po.BasePO;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Entity
@Data
@Table(name = "t_product")
public class ProductPO extends BasePO {

    /**
     * 商品编码
     */
    @Column(unique = true)
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
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 状态
     * 0：在用
     * 1：废弃
     */
    private Integer status;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CategoryPO category;

    public CategoryPO getCategory() {
        return category;
    }

    public void setCategory(CategoryPO category) {
        this.category = category;
    }
}
