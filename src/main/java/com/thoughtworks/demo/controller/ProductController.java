package com.thoughtworks.demo.controller;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("products")
public class ProductController {

  @Autowired
  ProductService service;

  @GetMapping()
  public Iterable<Product> getProduct() {
    return service.getProducts();
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public Product createProduct(@RequestBody Product product) {
    return service.createProduct(product);
  }
}
