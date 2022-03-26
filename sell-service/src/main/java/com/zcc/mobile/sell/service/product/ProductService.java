package com.zcc.mobile.sell.service.product;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.repository.product.ProductRepository;
import com.zcc.mobile.sell.dto.product.ProductDTO;
import com.zcc.mobile.sell.dto.product.command.SavaProductCommand;
import com.zcc.mobile.sell.dto.product.command.UpdateProductCommand;
import com.zcc.mobile.sell.mapper.product.ProductDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductDtoMapper productDtoMapper;

    public ProductService(ProductRepository repository, ProductDtoMapper productDtoMapper) {
        this.repository = repository;
        this.productDtoMapper = productDtoMapper;
    }

    public List<ProductDTO> getProductList() {
        return repository.listProducts()
                .stream()
                .filter(Objects::nonNull)
                .map(productDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<ProductDTO> getProductList(Pageable pageable) {
        return repository.listProducts(pageable)
                .map(productDtoMapper::toDto);
    }

    public ProductDTO createProduct(SavaProductCommand command) throws SellException {
        command.validate();
        return productDtoMapper.toDto(repository.save(command.getProduct()));
    }

    public ProductDTO updateProduct(UpdateProductCommand command) throws SellException {
        command.validate();
        return productDtoMapper.toDto(repository.save(command.getProduct()));
    }
}
