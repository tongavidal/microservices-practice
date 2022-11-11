package com.microservice.springboot.app.items.clients;

import com.microservice.springboot.app.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-products", url = "localhost:8001")
public interface ProductClientRest {

    @GetMapping("/list")
    public List<Product> list();

    @GetMapping("/list/{id}")
    public Product getProductDetails(@PathVariable Long id);
}
