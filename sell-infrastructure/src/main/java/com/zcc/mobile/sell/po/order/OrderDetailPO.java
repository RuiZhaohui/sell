package com.zcc.mobile.sell.po.order;

import com.zcc.mobile.sell.po.BasePO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
@Entity
@Table(name = "t_order_detail")
public class OrderDetailPO extends BasePO {

    /**
     * 主订单号
     */
    private String orderId;

    /**
     * 自订单号
     */
    private String detailOrderId;

    /**
     * 商品编码
     */
    private String productCode;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 子订单总价
     */
    private BigDecimal totalPrice;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
