package com.zcc.mobile.sell.web.vo.product;

import com.zcc.mobile.sell.web.vo.AbstractRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("产品新增修改")
public class ModifyProductRequest extends AbstractRequest {

    @NotNull(message = "the product to save can not be null")
    @Valid
    @ApiModelProperty("产品信息")
    private ProductType product;

}
