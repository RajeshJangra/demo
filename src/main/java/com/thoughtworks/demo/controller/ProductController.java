package com.thoughtworks.demo.controller;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController("products")
public class ProductController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  ProductService service;

  @GetMapping()
  public ResponseEntity<Iterable<Product>> getProduct() {
    return new ResponseEntity<>(service.getProducts(), OK);
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    return new ResponseEntity<>(service.createProduct(product), OK);
  }
}
