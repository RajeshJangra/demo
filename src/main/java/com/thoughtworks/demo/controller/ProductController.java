package com.thoughtworks.demo.controller;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("products")
public class ProductController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  ProductService service;

  @GetMapping()
  public Iterable<Product> getProduct() {
    return service.getProducts();
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public Product createProduct(@RequestBody Product product) {
    LOGGER.trace("Tracing");
    LOGGER.info("Debugging");
    LOGGER.error("Erroring");
    return service.createProduct(product);
  }
}
