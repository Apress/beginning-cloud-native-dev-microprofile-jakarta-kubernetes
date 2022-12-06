package org.microprofile.cloudnative.rest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @AfterEach
    void tearDown() {
        productService = null;
    }

    @Test
    void testGetProducts() {
        List<Product> products = productService.getProducts();

        assertNotNull(products);
        assertEquals(2, products.size());
    }
}