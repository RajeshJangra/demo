package com.thoughtworks.demo.domain;

import javax.persistence.Id;
import java.util.Objects;

public class Product {

  @Id
  private String id;
  private String name;
  private String description;

  public Product() {
  }

  public Product(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id) &&
        Objects.equals(name, product.name) &&
        Objects.equals(description, product.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    return "Product{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
