package com.zcc.mobile.sell.domain.entity.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
public class OrderDetail {

    /**
     * 主键
     */
    private long id;

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
    private int productQuantity;

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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
