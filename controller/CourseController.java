package com.example.User.controller;

import com.example.User.service.Services;
import com.example.User.user.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/c")
public class CourseController {
    @Autowired
    private Services service;

    @RequestMapping("/course")
    public Course saveCourse(@RequestBody Course curs){
        return service.saveCourse(curs);
    }
}
