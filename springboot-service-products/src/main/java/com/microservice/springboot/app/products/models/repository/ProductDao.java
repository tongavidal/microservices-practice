package com.microservice.springboot.app.products.models.repository;

import com.microservice.springboot.app.products.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
}
