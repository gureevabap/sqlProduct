package com.example.demo;


import java.util.Objects;
import java.util.StringJoiner;

public class Product {

    private Long id;
    private String name;
    private Long Price;

    public Product() {
    }

    public Product(Long id, String name, Long Price) {
        this.id = id;
        this.name = name;
        this.Price = Price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long Price) {
        this.Price = Price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Price == product.Price &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Price);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("Price='" + Price + "'")
                .toString();
    }
}