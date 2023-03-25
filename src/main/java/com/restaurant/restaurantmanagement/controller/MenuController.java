package com.restaurant.restaurantmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.restaurantmanagement.entities.Menu;
import com.restaurant.restaurantmanagement.service.MenuService;

@RestController
@CrossOrigin
public class MenuController {
    
    @Autowired
    private MenuService service;

    
    @PostMapping("/addMenu")
    public Menu addMenu(@RequestBody Menu menu){
        return service.saveMenu(menu);
    }
    

    @GetMapping("/getAllMenu")
    public List<Menu> getAllMenu(){
        return service.getAllMenu();
    }

    
    @GetMapping("/getMenuById/{id}")
    public Menu getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @DeleteMapping("/deleteMenuById/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/deleteAllMenu")
    public void deleteAll(){
        service.deleteAll();
    }

    // @DeleteMapping("/deleteDishByName/{name}")
    // public void deleteByName(@PathVariable String name){
    //     service.deleteByName(name);
    // }
}
