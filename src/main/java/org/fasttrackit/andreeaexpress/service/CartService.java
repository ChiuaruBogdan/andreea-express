package org.fasttrackit.andreeaexpress.service;

import org.fasttrackit.andreeaexpress.domain.Cart;
import org.fasttrackit.andreeaexpress.domain.Customer;
import org.fasttrackit.andreeaexpress.persistance.CartRepository;
import org.fasttrackit.andreeaexpress.transfer.cart.AddProductToCartRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

private final CartRepository cartRepository;
private final CustomerService customerService;

@Autowired
    public CartService(CartRepository cartRepository, CustomerService customerService) {
        this.cartRepository = cartRepository;
    this.customerService = customerService;
}

@Transactional
    public void addProductToCart(AddProductToCartRequest request){
    LOGGER.info("Adding prodcut to cart: {}", request);
        Cart cart = cartRepository.findById(request.getCustomerId())
                .orElse(new Cart());

        if(cart.getCustomer() == null) {
            LOGGER.debug("Cart doesn't exist. Retrieving customer to create a new cart.");
            Customer customer = customerService.getCustomer(request.getCustomerId());
            cart.setCustomer(customer);
        }

        cartRepository.save(cart);


    }
}
