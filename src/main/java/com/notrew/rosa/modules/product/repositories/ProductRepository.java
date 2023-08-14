package com.notrew.rosa.modules.product.repositories;

import com.notrew.rosa.modules.product.constants.Status;
import com.notrew.rosa.modules.product.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.status = :newStatus WHERE p.id = :productId")
    void updateStatusById(String productId, Status newStatus);
}
