package org.fasttrackit.andreeaexpress.persistance;

import org.fasttrackit.andreeaexpress.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
