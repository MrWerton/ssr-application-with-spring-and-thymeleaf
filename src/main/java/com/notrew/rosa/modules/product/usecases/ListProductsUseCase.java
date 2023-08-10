package com.notrew.rosa.modules.product.usecases;

import com.notrew.rosa.modules.product.entities.Product;
import com.notrew.rosa.modules.product.repositories.ProductRepository;
import com.notrew.rosa.shared.contracts.OutputUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsUseCase implements OutputUseCase<List<Product>> {
    private final ProductRepository productRepository;

    @Autowired
    public ListProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> call() {
        return productRepository.findAll();
    }
}
