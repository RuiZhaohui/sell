package com.zcc.mobile.sell.mapper.product;

import com.zcc.mobile.sell.domain.entity.product.Product;
import com.zcc.mobile.sell.dto.product.ProductDTO;
import org.mapstruct.Mapper;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Mapper(componentModel = "spring", uses = {CategoryDtoMapper.class})
public interface ProductDtoMapper {
    ProductDTO toDto(Product product);
}
