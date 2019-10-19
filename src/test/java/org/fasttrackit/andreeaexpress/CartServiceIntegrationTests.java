package org.fasttrackit.andreeaexpress;

import org.fasttrackit.andreeaexpress.domain.Customer;
import org.fasttrackit.andreeaexpress.service.CartService;
import org.fasttrackit.andreeaexpress.steps.CustomerSteps;
import org.fasttrackit.andreeaexpress.transfer.cart.AddProductToCartRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceIntegrationTests {

    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerSteps customerSteps;

    @Test
    public void testAddToCart_WhenNewCart_thenCreateCart() {
        Customer customer = customerSteps.createCustomer();

        AddProductToCartRequest request = new AddProductToCartRequest();
        request.setCustomerId(customer.getId());
//        TODO: replace this after mapping Cart-Product relantionship
        request.setProductId(10L);

        cartService.addProductToCart(request);
    }
}
