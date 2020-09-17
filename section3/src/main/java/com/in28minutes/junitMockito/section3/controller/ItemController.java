package com.in28minutes.junitMockito.section3.controller;

import com.in28minutes.junitMockito.section3.entity.Item;
import com.in28minutes.junitMockito.section3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {


    @Autowired
    ItemService itemService;


    @GetMapping(path = "/get-one")
    public Item getOne(){
        return new Item(23l,"biscuits",3,10.00);
    }

    @GetMapping(path = "/get-one-by-service")
    public Item getOneItem(){
        return this.itemService.getOneItemByService();
    }

    @GetMapping(path = "/get-all")
    public List<Item> getAlItemFromRepository(){
        return itemService.getAllItemFromRepository();
    }
}
