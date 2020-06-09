package com.example.demo;
import com.example.demo.Product;
import java.util.List;

public interface FindProductInterface {

    List<Product> findAll();
    Product findById(Long id);
    void insertProduct(String name, Long Price);

    void deleteById(long parseLong);
}


