package com.notrew.rosa.modules.product.usecases;

import com.notrew.rosa.modules.product.constants.Status;
import com.notrew.rosa.modules.product.dtos.ProductDTO;
import com.notrew.rosa.modules.product.entities.Product;
import com.notrew.rosa.modules.product.repositories.ProductRepository;
import com.notrew.rosa.shared.contracts.InputUseCase;
import com.notrew.rosa.shared.utils.UUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveProductUseCase implements InputUseCase<ProductDTO> {
    private final ProductRepository productRepository;

    @Autowired
    public SaveProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void call(ProductDTO data) {
        final var product = new Product();
        product.setId(UUIDGenerator.generate());
        product.setStatus(Status.AVAILABLE);
        BeanUtils.copyProperties(data, product);
        System.out.println(product);
        productRepository.save(product);
    }
}
