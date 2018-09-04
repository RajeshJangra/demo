package com.thoughtworks.demo.integrationtests;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
  @Autowired
  ProductService service;

  @Test
  @DisplayName("create a product")
  public void createProduct() {
    Product product = new Product("Hello", "hello");

    Product returnedProduct = service.createProduct(product);

    assertEquals(product, returnedProduct);
  }
}
