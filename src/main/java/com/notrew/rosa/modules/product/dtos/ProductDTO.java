package com.notrew.rosa.modules.product.dtos;

public record ProductDTO(
        String id,
        String name,
        String destination,
        String price,
        String profitabilityRate,
        int term,
        double administrationRate
) {
}
