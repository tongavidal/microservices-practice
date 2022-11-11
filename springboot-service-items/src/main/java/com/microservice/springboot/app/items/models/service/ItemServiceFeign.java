package com.microservice.springboot.app.items.models.service;

import com.microservice.springboot.app.items.clients.ProductClientRest;
import com.microservice.springboot.app.items.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductClientRest feignClient;

    @Override
    public List<Item> findAll() {
        return feignClient.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        return new Item(feignClient.getProductDetails(id), amount);
    }
}
