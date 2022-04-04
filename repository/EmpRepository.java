package com.example.User.repository;

import com.example.User.user.Animal;
import com.example.User.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepository extends JpaRepository <Animal, Long> {
    Page<Animal> findByNameContaining(String name, Pageable pageable);

   // List<Animal> animals = findByNameInAnimal(String name);
   @Query(value = "select * from animal a where a.name like %:keyword%", nativeQuery = true)

   List<Animal> findByKeyword(@Param("keyword") String keyword);
}
