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
@Table(name = "t_order")
public class OrderPO extends BasePO {
    private String orderId;
    private String buyer;
    private BigDecimal amount;
    private Integer orderStatus;
    private Integer status;
}
