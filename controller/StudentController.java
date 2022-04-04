package com.example.User.controller;

import com.example.User.service.Services;
import com.example.User.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/s")
public class StudentController {
    @Autowired
    private Services service;

    @RequestMapping("/student")
    public Student saveStudent(@RequestBody Student st){
        return service.saveStudent(st);
    }
}
