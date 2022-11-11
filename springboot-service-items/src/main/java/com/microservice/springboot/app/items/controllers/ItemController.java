package com.microservice.springboot.app.items.controllers;

import com.microservice.springboot.app.items.models.Item;
import com.microservice.springboot.app.items.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item> list() {
        return itemService.findAll();
    }

    @GetMapping("/list/{id}/amount/{amount}")
    public Item getItemDetails(@PathVariable Long id, @PathVariable Integer amount) {
        return itemService.findById(id, amount);
    }
}
