package com.zcc.mobile.sell.po.customer;

import com.zcc.mobile.sell.po.BasePO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Data
@Entity
@Table(name = "t_customer")
public class CustomerPO extends BasePO {

    private String username;

    private Integer gender;

    private String mobile;

    private String address;

    private String addressDetail;

    private Date updateTime;

    private Date createdTime;
}
