package com.zcc.mobile.sell.domain.entity.order;

import com.zcc.mobile.sell.domain.enums.OrderStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
public class Order {

    private long id;
    private String orderId;
    private String buyer;
    private BigDecimal amount;
    private OrderStatusEnum orderStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
