package org.fasttrackit.andreeaexpress.persistance;

import org.fasttrackit.andreeaexpress.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//Nested Properties below
    Page<Review> findByProductId(long productId, Pageable pageable);

}
