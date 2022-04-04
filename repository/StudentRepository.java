package com.example.User.repository;

import com.example.User.user.Course;
import com.example.User.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
