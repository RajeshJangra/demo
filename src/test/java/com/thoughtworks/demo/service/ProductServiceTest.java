package com.thoughtworks.demo.service;

import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.repository.ProductRepository;
import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DisplayName(value = "Product Service Unit tests")
class ProductServiceTest {

  @InjectMocks
  private ProductService service;
  @Mock
  private ProductRepository repository;

  @Test
  @DisplayName("should create a product")
  void createProduct() {
    Product expected = new Product("name", "description");
    given(repository.insert(expected)).willReturn(expected);
    Product returned = service.createProduct(expected);

    assertEquals(expected, returned);
  }

  @Test
  @DisplayName("should return all products")
  void getProducts() {
    List<Product> expetcedProducts = Collections.singletonList(new Product("name", "description"));
    given(repository.findAll()).willReturn(expetcedProducts);
    Iterable<Product> returnedProducts = service.getProducts();

    assertEquals(expetcedProducts, returnedProducts);
  }
}