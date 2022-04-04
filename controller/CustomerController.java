package com.example.User.controller;

import com.example.User.service.Services;
import com.example.User.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cus")
public class CustomerController {

    @Autowired
    private Services service;

    @RequestMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }
}
