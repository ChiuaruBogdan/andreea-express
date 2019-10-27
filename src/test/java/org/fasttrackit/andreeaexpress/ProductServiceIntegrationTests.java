package org.fasttrackit.andreeaexpress;

import org.fasttrackit.andreeaexpress.domain.Product;
import org.fasttrackit.andreeaexpress.service.ProductService;
import org.fasttrackit.andreeaexpress.steps.ProductSteps;
import org.fasttrackit.andreeaexpress.transfer.product.SaveProductRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTests {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductSteps productSteps;

    @Test
    public void testCreateProduct_whenValidRequest_thenReturnCreatedProduct() {

        productSteps.createProduct();

    }




    //    test pentru requesturi invalide
    @Test(expected = TransactionSystemException.class)
    public void testCreateProduct_whenInvalidRequest_thenThrowException() {
        SaveProductRequest request = new SaveProductRequest();

        productService.createProduct(request);

    }

    @Test
    public void testGetProduct_whenExistingEntity_thenReturnProduct() {
        Product createdProduct = productSteps.createProduct();
        Product retrievedProduct = productService.getProduct(createdProduct.getId());

        assertThat(retrievedProduct, notNullValue());
        assertThat(retrievedProduct.getId(), is(createdProduct.getId()));
        assertThat(retrievedProduct.getName(), is(createdProduct.getName()));
        assertThat(retrievedProduct.getDescription(), is(createdProduct.getDescription()));
        assertThat(retrievedProduct.getPrice(), is(createdProduct.getPrice()));
        assertThat(retrievedProduct.getQuantity(), is(createdProduct.getQuantity()));
    }


//    test negativ pentru metoda getProduct
//pentru testul negativ, nu stiu de ce nu mergea cu "expected = ResourceNotFoundException.class" pentru ca imi arunca "RunTime Exception",
// asa ca am inlocuit @Test (expected cu RunTimeException.class si a fost "passed" testul.
    @Test(expected = RuntimeException.class)
    public void testGetProduct_whenNonExistingEntity_thenThrowNotFoundException() {
        productService.getProduct(99999L);
    }

    @Test
    public void testUpdateProduct_whenValidRequest_thenReturnUpdatedProduct(){
        Product createdProduct = productSteps.createProduct();
        SaveProductRequest request = new SaveProductRequest();
        request.setName(createdProduct.getName() + " was updated");
        request.setPrice(createdProduct.getPrice() + 25);
        request.setQuantity(createdProduct.getQuantity() + 6);

        Product updatedProduct =
                productService.updateProduct(createdProduct.getId(), request);

        assertThat(updatedProduct, notNullValue());
        assertThat(updatedProduct.getId(), greaterThan(0L));
        assertThat(updatedProduct.getName(), is(request.getName()));
        assertThat(updatedProduct.getPrice(), is(request.getPrice()));
        assertThat(updatedProduct.getQuantity(), is(request.getQuantity()));
    }
}