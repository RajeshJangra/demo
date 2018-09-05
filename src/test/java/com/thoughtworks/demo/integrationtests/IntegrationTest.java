package com.thoughtworks.demo.integrationtests;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.thoughtworks.demo.domain.Product;
import com.thoughtworks.demo.service.ProductService;
import org.junit.AfterClass;
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
    dropCollection();
  }

  @AfterClass
  public void dropCollection() {
    MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
    MongoDatabase db = mongoClient.getDatabase("integration");
    MongoCollection collection = db.getCollection("product");
    collection.drop();
  }
}
