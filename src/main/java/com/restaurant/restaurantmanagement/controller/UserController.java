package com.restaurant.restaurantmanagement.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.restaurantmanagement.service.UserService;
import com.restaurant.restaurantmanagement.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/auth/{email}/{password}")
    public int auth(@PathVariable String email, @PathVariable String password){
        return service.auth(email, password);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    
}
