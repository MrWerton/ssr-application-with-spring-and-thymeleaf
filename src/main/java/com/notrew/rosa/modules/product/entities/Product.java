package com.notrew.rosa.modules.product.entities;

import com.notrew.rosa.modules.product.constants.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String destination;
    private String price;
    @Column(name = "profitability_rate")
    private String profitabilityRate;
    private int term;
    @Column(name = "administration_rate")
    private double administrationRate;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "due_date")
    private String dueDate;


    @Column(name = "daily_liquidity")
    private Boolean dailyLiquidity;

}
