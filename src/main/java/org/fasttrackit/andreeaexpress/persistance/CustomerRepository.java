package org.fasttrackit.andreeaexpress.persistance;

import org.fasttrackit.andreeaexpress.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



}
