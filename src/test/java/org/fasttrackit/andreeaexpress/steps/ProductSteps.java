package org.fasttrackit.andreeaexpress.steps;

import org.fasttrackit.andreeaexpress.domain.Product;
import org.fasttrackit.andreeaexpress.service.ProductService;
import org.fasttrackit.andreeaexpress.transfer.product.SaveProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Component
public class ProductSteps {

    @Autowired
    private  ProductService productService;

    public Product createProduct() {
        SaveProductRequest request = new SaveProductRequest();
        request.setName("Galaxy Note 10 Plus");
        request.setDescription("The latest smartphone from the world's biggest tech company.");
        request.setPrice(2500);
        request.setQuantity(100);


        Product product = productService.createProduct(request);

        assertThat(product, notNullValue());
        assertThat(product.getId(), notNullValue());
        assertThat(product.getId(), greaterThan(0L));
        assertThat(product.getName(), is(request.getName()));
        assertThat(product.getDescription(), is(request.getDescription()));
        assertThat(product.getQuantity(), is(request.getQuantity()));

        return product;
    }
}
