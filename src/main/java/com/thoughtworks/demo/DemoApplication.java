package com.thoughtworks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner getCommandLineRunner(ProductRepository repository) {
//    return args -> {
//      List<Product> products = new LinkedList<>();
//      products.add(new Product("1", "Demo Prduct 1", "Demo Description 1"));
//      products.add(new Product("2", "Demo Prduct 2", "Demo Description 2"));
//      repository.insert(products);
//    };
//  }
}
