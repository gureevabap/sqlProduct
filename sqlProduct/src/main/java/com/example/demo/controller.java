package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class controller {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private findProducts productService;
    @RequestMapping("/products")
    public List<Product> findProducts() {
        return productService.findAll();
    }

    @RequestMapping(value="/products/getProduct", method = RequestMethod.GET)
    public Product findProduct(@RequestParam("productId") String productId) {
        return productService.findById(Long.parseLong(productId));
    }

    @RequestMapping(value="/products/deleteProduct", method = RequestMethod.GET)
    public void deleteProduct(@RequestParam("productId") String productId) {
        productService.deleteById(Long.parseLong(productId));
    }

    @RequestMapping(value = "/products/addproduct", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody Product product) {
        productService.insertProduct(product.getName(), product.getPrice());
    }

}