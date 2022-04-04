package com.example.User.user;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String course_name;
    private double fee;


    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
