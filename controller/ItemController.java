package com.example.User.controller;

import com.example.User.service.Services;
import com.example.User.user.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itm")
public class ItemController {
    @Autowired
    private Services service;

    @RequestMapping("/item")
    public Item saveItem(@RequestBody Item item){
        return service.saveItem(item);
    }
}
