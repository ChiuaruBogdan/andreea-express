package org.fasttrackit.andreeaexpress.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.andreeaexpress.domain.Customer;
import org.fasttrackit.andreeaexpress.persistance.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger((Customer.class));

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    public CustomerService(CustomerRepository customerRepository, ObjectMapper objectMapper) {
        this.customerRepository = customerRepository;
        this.objectMapper = objectMapper;


    }
//needs more work.

}
