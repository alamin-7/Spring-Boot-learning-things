package com.example.User.repository;

import com.example.User.user.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Long> {
}
