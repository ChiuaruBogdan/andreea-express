package org.fasttrackit.andreeaexpress.persistance;

import org.fasttrackit.andreeaexpress.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {


}
