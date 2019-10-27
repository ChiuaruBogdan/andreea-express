package org.fasttrackit.andreeaexpress.service;

import org.fasttrackit.andreeaexpress.domain.Cart;
import org.fasttrackit.andreeaexpress.domain.Customer;
import org.fasttrackit.andreeaexpress.domain.Product;
import org.fasttrackit.andreeaexpress.exception.ResourceNotFoundException;
import org.fasttrackit.andreeaexpress.persistance.CartRepository;
import org.fasttrackit.andreeaexpress.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.andreeaexpress.transfer.cart.CartResponse;
import org.fasttrackit.andreeaexpress.transfer.product.ProductInCartResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerService customerService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Transactional
    public void addProductToCart(AddProductToCartRequest request) {
        LOGGER.info("Adding prodcut to cart: {}", request);
        Cart cart = cartRepository.findById(request.getCustomerId())
                .orElse(new Cart());

        if (cart.getCustomer() == null) {
            LOGGER.debug("Cart doesn't exist. Retrieving customer to create a new cart.");
            Customer customer = customerService.getCustomer(request.getCustomerId());
            cart.setCustomer(customer);
        }

        Product product = productService.getProduct(request.getProductId());
        cart.addToCart(product);

        cartRepository.save(cart);
    }

    @Transactional
    public CartResponse getCart(Long customerId) {
        Cart cart = cartRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("The customer doesn't have any cart registered to the id" + customerId));

        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());

        Set<ProductInCartResponse> products = new HashSet<>();

        Iterator<Product> iterator = cart.getProducts().iterator();

        while(iterator.hasNext()) {
            Product product = iterator.next();

        ProductInCartResponse productInCartResponse = new ProductInCartResponse();
        productInCartResponse.setId(product.getId());
        productInCartResponse.setName(product.getName());
        productInCartResponse.setPrice(product.getPrice());

        products.add(productInCartResponse);
        }
        cartResponse.setProducts(products);

        return cartResponse;
    }
}
