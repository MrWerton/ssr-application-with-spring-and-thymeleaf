package com.notrew.rosa.modules.product.usecases;

import com.notrew.rosa.modules.product.repositories.ProductRepository;
import com.notrew.rosa.shared.contracts.InputUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveProductUseCase implements InputUseCase<String> {
    private final ProductRepository productRepository;

    @Autowired
    public RemoveProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void call(String data) {

        productRepository.deleteById(data);
    }
}
