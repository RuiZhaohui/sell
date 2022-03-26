package com.zcc.mobile.sell.mapper.product;

import com.zcc.mobile.sell.domain.entity.product.Product;
import com.zcc.mobile.sell.po.product.ProductPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Mapper(componentModel = "spring", uses = {CategoryPoMapper.class})
public interface ProductPoMapper {
    Product toEntity(ProductPO po);

    @Mappings({
            @Mapping(target = "id", expression = "java(0 == product.getId() ? null : product.getId())"),
            @Mapping(target = "updateTime", ignore = true),
            @Mapping(target = "createTime", ignore = true)
    })
    ProductPO toPo(Product product);
}
