package org.fasttrackit.andreeaexpress.service;

import org.fasttrackit.andreeaexpress.domain.Product;
import org.fasttrackit.andreeaexpress.persistance.ProductRepository;
import org.fasttrackit.andreeaexpress.transfer.product.SaveProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(SaveProductRequest request) {
        LOGGER.info("Creating product: {}", request);

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setImagePath(request.getImagePath());

       return productRepository.save(product);
    }
}
