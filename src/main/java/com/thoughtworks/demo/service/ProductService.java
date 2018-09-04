package com.thoughtworks.demo.service;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Iterable<Product> getProducts() {
    return repository.findAll();
  }

  public Product createProduct(Product product) {
    return repository.insert(product);
  }
}
