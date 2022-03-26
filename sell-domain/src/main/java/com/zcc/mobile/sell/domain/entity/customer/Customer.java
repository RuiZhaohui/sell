package com.zcc.mobile.sell.domain.entity.customer;

import com.zcc.mobile.sell.domain.enums.GenderEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
public class Customer {
    /**
     * 用户id
     */
    private long id;

    private String username;

    private GenderEnum gender;

    private String mobile;

    private String address;

    private String addressDetail;

    private LocalDateTime updateTime;

    private LocalDateTime createdTime;
}
