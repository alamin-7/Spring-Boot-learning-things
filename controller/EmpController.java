package com.example.User.controller;

import com.example.User.repository.EmpRepository;
import com.example.User.user.Animal;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpRepository empRepository;

    @PostMapping("/post")
    public Animal postData(@RequestBody Animal test){
        return empRepository.save(test);
    }

    @GetMapping ("/get")
    public List<Animal> getData(){
        return empRepository.findAll();
    }

    @GetMapping("/page")
    public Page<Animal>  getAnimal(@RequestParam("page") int page, @RequestParam("size") int size){

        Pageable firstPageWithTwoElements = PageRequest.of(page, size);
        Page<Animal> allEmpoyee = empRepository.findAll(firstPageWithTwoElements);
        Pageable secondPageWithFiveElements = PageRequest.of(page, size);
      /*  List<Employee> allTenDollarProducts =
                empRepository.findAllByRole(10L, secondPageWithFiveElements);*/
        return allEmpoyee;
    }

    // searching

    @GetMapping("/search/{query}")
    public List<Animal> searchAnimal(@PathVariable("query") String query){
        List<Animal> animals= empRepository.findByKeyword(query);
        return animals;
    }


}
