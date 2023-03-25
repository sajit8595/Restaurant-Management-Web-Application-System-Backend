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

import com.restaurant.restaurantmanagement.entities.*;
import com.restaurant.restaurantmanagement.service.*;

@RestController
@CrossOrigin
public class OrderController {
    
    @Autowired
    private OrderService service;

    @Autowired
    private MenuService ms;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        Menu m = ms.getById(order.getMenuId());
        order.setMenu(m.getName());
        order.setStatus("QUEUE");
        order.setMenuRate(m.getRate());
        return service.saveOrder(order);
    }
    
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public Order getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/deleteAllOrders")
    public void deleteAll(){
        service.deleteAll();
    }

    @PostMapping("/statusChange/{orderId}/{status}")
    public Order statusChange(@PathVariable Integer orderId, @PathVariable String status){
        Order order = getById(orderId);
        order.setStatus(status);
        return service.saveOrder(order);
    }



}