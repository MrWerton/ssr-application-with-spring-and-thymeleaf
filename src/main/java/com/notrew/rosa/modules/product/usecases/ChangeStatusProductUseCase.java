package com.notrew.rosa.modules.product.usecases;

import com.notrew.rosa.modules.product.dtos.ChangeStatusDto;
import com.notrew.rosa.modules.product.repositories.ProductRepository;
import com.notrew.rosa.shared.contracts.InputUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeStatusProductUseCase implements InputUseCase<ChangeStatusDto> {
    private final ProductRepository productRepository;

    @Autowired
    public ChangeStatusProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void call(ChangeStatusDto data) {

        final var id = data.id();
        final var status = data.getStatus();
        productRepository.updateStatusById(id, status);
    }
}
