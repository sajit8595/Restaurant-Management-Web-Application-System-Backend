package com.restaurant.restaurantmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagement.entities.Customer;
import com.restaurant.restaurantmanagement.repository.CustomerRepository;

import java.util.*;

@Service
public class CustomerService {

   @Autowired
   private CustomerRepository repo;

   public Customer saveCustomer(Customer customer) {
      return repo.save(customer);
   }

   public List<Customer> getAllCustomers() {
      return repo.findAll();
   }

   public Customer getById(int id) {
      return repo.findById(id).orElse(null);
   }

   public void deleteById(int id) {
      repo.deleteById(id);
   }

   public void deleteAll() {
      repo.deleteAll();
   }

}
