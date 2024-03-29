package org.fasttrackit.andreeaexpress;


import org.fasttrackit.andreeaexpress.domain.Customer;
import org.fasttrackit.andreeaexpress.service.CustomerService;
import org.fasttrackit.andreeaexpress.steps.CustomerSteps;
import org.fasttrackit.andreeaexpress.transfer.customer.SaveCustomerRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerSteps customerSteps;
    @Test
    public void testCreateCustomer_whenValidRequest_thenReturnCustomer(){

        customerSteps.createCustomer();

    }
}
