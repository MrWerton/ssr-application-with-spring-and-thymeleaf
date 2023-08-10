package com.notrew.rosa.modules.product.usecases;

import com.notrew.rosa.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveProductUseCase {
    private final ProductRepository productRepository;

    @Autowired
    public SaveProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    call() {

    }
}
