package com.restaurant.restaurantmanagement.controller;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.restaurant.restaurantmanagement.entities.Customer;
import com.restaurant.restaurantmanagement.service.CustomerService;

import java.util.*;

@RestController
@CrossOrigin("*")
public class CustomerController {
    
    @Autowired
    private CustomerService service;
    
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    
    @GetMapping("/getCustomerById/{id}")
    public Customer getById(@PathVariable Integer id){
        return service.getById(id);
    }


    @DeleteMapping("/deleteCustomerById/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/deleteAllCustomers")
    public void deleteAll(){
        service.deleteAll();
    }

}
