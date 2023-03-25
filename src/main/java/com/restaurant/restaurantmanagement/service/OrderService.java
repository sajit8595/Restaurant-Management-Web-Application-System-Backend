package com.restaurant.restaurantmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagement.entities.Order;
import com.restaurant.restaurantmanagement.repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repo;

    public Order saveOrder(Order order){
        return repo.save(order);
    }

    public List<Order> getAllOrders(){
        return repo.findAll();
    }

    public Order getById(int id){
        return repo.findById(id).orElse(null);
    }
    
    public void deleteById(int id){
        repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

   
}
