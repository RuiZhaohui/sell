package com.zcc.mobile.sell.po.product;

import com.zcc.mobile.sell.po.BasePO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
@Entity
@Table(name = "t_category")
public class CategoryPO extends BasePO {
    /**
     * 名称
     */
    @Column(unique = true)
    private String name;

    /**
     * 描述
     */
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ToString.Exclude
    @Transient
    private List<ProductPO> products;

    @ManyToOne
    @JoinColumn(name = "type_id", unique = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CategoryTypePO type;
}
