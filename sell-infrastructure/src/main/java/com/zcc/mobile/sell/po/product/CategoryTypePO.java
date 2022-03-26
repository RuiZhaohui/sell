package com.zcc.mobile.sell.po.product;

import com.zcc.mobile.sell.po.BasePO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
@Entity
@Table(name = "t_category_type")
public class CategoryTypePO extends BasePO {
    private String code;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Transient
    private List<CategoryPO> categories;
}
