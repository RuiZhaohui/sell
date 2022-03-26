package com.zcc.mobile.sell.web.assmbler.product;

import com.zcc.mobile.sell.common.exceptions.SellException;
import com.zcc.mobile.sell.domain.entity.product.Category;
import com.zcc.mobile.sell.domain.entity.product.Product;
import com.zcc.mobile.sell.domain.repository.product.CategoryRepository;
import com.zcc.mobile.sell.domain.repository.product.ProductRepository;
import com.zcc.mobile.sell.dto.product.command.SavaProductCommand;
import com.zcc.mobile.sell.dto.product.command.UpdateProductCommand;
import com.zcc.mobile.sell.web.vo.product.ModifyProductRequest;
import com.zcc.mobile.sell.web.vo.product.ProductType;
import org.springframework.stereotype.Component;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Component
public class ModifyProductRequestAssembler {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ModifyProductRequestAssembler(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public SavaProductCommand toSaveProductCommand(ModifyProductRequest request) throws SellException {
        SavaProductCommand command = new SavaProductCommand();
        if (null != request && null != request.getProduct()) {
            ProductType productModel = request.getProduct();
            if (productRepository.findByCode(productModel.getCode()).isPresent()) {
                throw new SellException("this product is not a new one");
            }
            Product product = convert(productModel);
            categoryRepository.findById(productModel.getCategory()).ifPresent(product::setCategory);
            command.setProduct(product);
        }
        return command;
    }

    public UpdateProductCommand toUpdateProductCommand(ModifyProductRequest request) throws SellException {
        UpdateProductCommand command = new UpdateProductCommand();
        if (null != request && null != request.getProduct()) {
            ProductType productModel = request.getProduct();
            productRepository.findByCode(productModel.getCode())
                    .orElseThrow(() -> new SellException("can not find product"));
            Product product = convert(productModel);
            categoryRepository.findById(productModel.getCategory()).ifPresent(product::setCategory);
            command.setProduct(product);
        }
        return command;
    }

    public Product convert(ProductType productType) {
        if (null == productType) {
            return null;
        }
        Product product = new Product();
        product.setName(productType.getName());
        product.setCode(productType.getCode());
        product.setImage(productType.getImg());
        product.setDescription(productType.getDescription());
        product.setPrice(productType.getPrice());
        product.setStock(productType.getStock());
        if (null != productType.getCategory()) {
            Category category = new Category();
            category.setId(productType.getCategory());
        }
        return product;
    }
}
