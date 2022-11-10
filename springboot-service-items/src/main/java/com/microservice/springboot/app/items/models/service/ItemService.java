package com.microservice.springboot.app.items.models.service;

import com.microservice.springboot.app.items.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer amount);
}
