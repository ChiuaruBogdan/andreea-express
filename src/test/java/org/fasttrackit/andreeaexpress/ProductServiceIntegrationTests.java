package org.fasttrackit.andreeaexpress;

import org.fasttrackit.andreeaexpress.domain.Product;
import org.fasttrackit.andreeaexpress.service.ProductService;
import org.fasttrackit.andreeaexpress.transfer.product.SaveProductRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void testCreateProduct_whenValidRequest_thenReturnCreatedProduct() {

        SaveProductRequest request = new SaveProductRequest();
        request.setName("Smartwatch");
        request.setDescription("A piece of technology that you can wear on your wrist.");
        request.setPrice(1400);
        request.setQuantity(100);


        Product product = productService.createProduct(request);

        assertThat(product, notNullValue());
        assertThat(product.getId(), notNullValue());
        assertThat(product.getId(), greaterThan(0L));
        assertThat(product.getName(), is(request.getName()));
        assertThat(product.getDescription(), is(request.getDescription()));
        assertThat(product.getQuantity(), is(request.getQuantity()));

    }


}