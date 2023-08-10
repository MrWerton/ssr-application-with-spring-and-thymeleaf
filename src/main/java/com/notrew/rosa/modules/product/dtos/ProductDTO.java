package com.notrew.rosa.modules.product.dtos;


import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String destination;
    private String price;
    private String profitabilityRate;
    private int term;
    private double administrationRate;
}
