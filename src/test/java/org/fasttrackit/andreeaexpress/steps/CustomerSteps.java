package org.fasttrackit.andreeaexpress.steps;

import org.fasttrackit.andreeaexpress.domain.Customer;
import org.fasttrackit.andreeaexpress.service.CustomerService;
import org.fasttrackit.andreeaexpress.transfer.customer.SaveCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@Component
public class CustomerSteps {

    @Autowired
    private CustomerService customerService;

    public Customer createCustomer(){
        SaveCustomerRequest request = new SaveCustomerRequest();
        request.setFirstName("Vasilica");
        request.setLastName("Ionescu");

        Customer customer = customerService.createCustomer(request);

        assertThat(customer, notNullValue());
        assertThat(customer.getId(), greaterThan(0L));
        assertThat(customer.getFirstName(), is(request.getFirstName()));
        assertThat(customer.getLastName(), is(request.getLastName()));

        return customer;
    }
}
