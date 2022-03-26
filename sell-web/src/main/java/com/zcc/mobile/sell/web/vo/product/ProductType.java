package com.zcc.mobile.sell.web.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
@ApiModel("产品信息")
public class ProductType {

    @NotBlank(message = "product name can not be null")
    @ApiModelProperty("产品名称")
    private String name;
    @NotBlank(message = "product code can not be null")
    @ApiModelProperty("产品编码")
    private String code;
    @ApiModelProperty("产品图片地址")
    private String img;
    @ApiModelProperty("产品描述")
    private String description;
    @NotNull(message = "product price can not be null")
    @ApiModelProperty("产品价格")
    private BigDecimal price;
    @NotNull(message = "product stock can not be null")
    @ApiModelProperty("产品库存")
    private Integer stock;
    @ApiModelProperty("产品分类id")
    private Long category;
}
