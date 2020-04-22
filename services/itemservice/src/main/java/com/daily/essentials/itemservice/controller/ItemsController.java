package com.daily.essentials.itemservice.controller;

import com.daily.essentials.itemservice.model.Item;
import com.daily.essentials.itemservice.model.Itemcatalog;
import com.daily.essentials.itemservice.service.implementation.Itemserviceimplementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class ItemsController {

    Itemserviceimplementation itemserviceimplementation;

    ItemsController(Itemserviceimplementation itemserviceimplementation)
    {
        this.itemserviceimplementation=itemserviceimplementation;
    }

    @CrossOrigin("*")
    @GetMapping("/anything")
    @ResponseBody
    public String getsomething()
    {
        return "yo mama";
    }


    @CrossOrigin("*")
    @GetMapping("/items")
    @ResponseBody
    public List<Item> getAllItems() {
    	return itemserviceimplementation.getAllItems();
    }

    @CrossOrigin("*")
    @GetMapping("/items/{itemId}")
    @ResponseBody
    public Item getItemByid(@PathVariable long itemId) {
        return itemserviceimplementation.getItemByid(itemId);
    }

    @CrossOrigin("*")
    @GetMapping("/items/{itemId}/available")
    @ResponseBody
    public Item checkItemAvailability(@PathVariable long itemId) {
        return itemserviceimplementation.getItemAvailableByid(itemId);
    }

    @CrossOrigin("*")
    @PostMapping("/items")
    @ResponseBody
    public void addNewItem(@RequestBody Item item) {
    	itemserviceimplementation.addNewItem(item);
    }

    @CrossOrigin("*")
    @PostMapping("/items/catalog")
    @ResponseBody
    public void addNewItemCatalog(@RequestBody Itemcatalog itemcatalog)
    {
        itemserviceimplementation.addNewItemCatalog(itemcatalog);
    }
}
