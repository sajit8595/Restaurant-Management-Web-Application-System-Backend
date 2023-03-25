package com.restaurant.restaurantmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantmanagement.entities.Tables;
import com.restaurant.restaurantmanagement.service.TablesService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController 
@CrossOrigin
public class TablesController {

    @Autowired
    private TablesService service;
    
    @PostMapping("/addTable")
    public Tables addTable(@RequestBody Tables table){
        return service.saveTable(table);
    }

    @GetMapping("/getAllTables")
    public List<Tables> getAllTables(){
        return service.getAllTables();
    }

    
    @GetMapping("/getTableById/{id}")
    public Tables getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @DeleteMapping("/deleteTableById/{id}")
    public void deleteById(@PathVariable Integer id){
            service.deleteById(id);
    }

    @DeleteMapping("/deleteAllTables")
    public void deleteAll(){
        service.deleteAll();
    }
    
    @PutMapping("bookTable/{id}/{name}")
    public void bookTable(@PathVariable Integer id, @PathVariable String name) {
       service.bookTable(id, name);
    }

    @PutMapping("payTable/{id}/{review}")
    public void payTable(@PathVariable Integer id, @PathVariable String review) {
       service.payTable(id, review);
    }


}
