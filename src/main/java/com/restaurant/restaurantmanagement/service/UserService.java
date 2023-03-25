package com.restaurant.restaurantmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.restaurantmanagement.repository.UserRepository;
import com.restaurant.restaurantmanagement.entities.User;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public int auth(String email, String password){
        User user = getUser(email);
        if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password))
            return user.getAccess();
        return 0;
    }

    public User getUser(String email){
        List<User> us = repo.findAll();
        for(User x: us)
            if (x.getEmail().equals(email))
                return x;
        return null;
    }

    public void deleteUser(int id){
        repo.deleteById(id);
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }
    
}
