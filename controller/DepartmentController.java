package com.example.User.controller;

import com.example.User.service.Services;
import com.example.User.user.Department;
import com.example.User.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/d")
public class DepartmentController {

    @Autowired
    private Services service;
    // save
    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department dept){

        return service.saveDept(dept);
    }
}
