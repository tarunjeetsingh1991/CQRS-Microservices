package com.javatechie.controller;

import com.javatechie.entity.Product;
import com.javatechie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> fetchAllProducts() {
        return repository.findAll();
    }
}
