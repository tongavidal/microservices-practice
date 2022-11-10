package com.microservice.springboot.app.products.controllers;

import com.microservice.springboot.app.products.models.entity.Product;
import com.microservice.springboot.app.products.models.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/list/{id}")
    public Product getProductDetails(@PathVariable Long id) {
        return productService.findById(id);
    }
}
