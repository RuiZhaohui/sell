package com.zcc.mobile.sell.domain.model.vo.product;

import com.zcc.mobile.sell.domain.model.vo.AbstractRequest;
import lombok.Data;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Data
public class ModifyProductRequest extends AbstractRequest {

    private ProductType product;

}
