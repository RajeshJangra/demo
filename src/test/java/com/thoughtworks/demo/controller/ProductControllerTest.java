package com.thoughtworks.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProductController.class, secure = false)
@DisplayName("Product Controller tests")
class ProductControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService service;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @DisplayName("should create a Product")
  void testCreateProduct() throws Exception {
    Product product = new Product("Dummy Product", "Dummy Description");

    given(service.createProduct(product)).willReturn(product);

    mockMvc
        .perform(post("/products")
            .content(objectMapper.writeValueAsString(product))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(product)));
  }

  @Test
  @DisplayName("should fetch all Products")
  void testGetProducts() throws Exception {
    List<Product> productList = singletonList(new Product("Dummy Product", "Dummy Description"));

    given(service.getProducts()).willReturn(productList);

    mockMvc
        .perform(get("/products")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(productList)));
  }

}