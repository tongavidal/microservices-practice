package com.microservice.springboot.app.items.models.service;

import com.microservice.springboot.app.items.models.Item;
import com.microservice.springboot.app.items.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(clientRest.getForObject("http://localhost:8001/list", Product[].class));
        return products.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        Map<String, String> pathVariableMap = new HashMap<>();
        pathVariableMap.put("id", id.toString());
        Product product = clientRest.getForObject("http://localhost:8001/list/{id}", Product.class, pathVariableMap);
        return new Item(product, amount);
    }
}
