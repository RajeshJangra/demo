package com.thoughtworks.demo.controller;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("products")
public class ProductController {

  @Autowired
  ProductService service;

  @GetMapping()
  public Iterable<Product> getProduct() {
    return service.getProducts();
  }
}
