package com.notrew.rosa.modules.product;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String destination;
    private String price;
    private String profitabilityRate;
    private int term;
    private double administrationRate;

}
