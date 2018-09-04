package com.thoughtworks.demo.service;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Iterable<Product> getProducts() {
    List<Product> products = new LinkedList<>();
    products.add(new Product("1", "Demo Prduct 1", "Demo Description 1"));
    products.add(new Product("2", "Demo Prduct 2", "Demo Description 2"));
    return products;
    //return repository.findAll();
  }
}
