package org.fasttrackit.andreeaexpress.persistance;

import org.fasttrackit.andreeaexpress.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContaining(String partialName, Pageable pageable);
    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(
            String partialName, int minimumQuantity ,Pageable pageable);

// Named Query mai jos si jpql Syntax
    @Query("SELECT product FROM Product product WHERE name LIKE ' :%partialName%'")
    List<Product> findByPartialName(String partialName);
}
