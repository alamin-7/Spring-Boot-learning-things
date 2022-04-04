package com.example.User.controller;

import com.example.User.repository.UserRepository;
import com.example.User.service.Services;
import com.example.User.user.User;
import com.example.User.user.UserDTO;
import com.example.User.user.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*@RestController
@RequestMapping("/api/u")
public class UserController {

    @Autowired
    private Services service;
    @Autowired
    private UserRepository userRepository;

    // for getting web content
    @RequestMapping(value = "/index")
    public String web(){
        return "index";
    }
    //demo
    @GetMapping("/demo")
//    @RequestMapping(value = "/demo", method = RequestMethod.GET)
      public String demo(){
        return "This is a test";
    }

    // create user
    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
         return service.saveUser(user);
    }
    // get all users
    @GetMapping("/allusers")
    public List<User> getAlluser(){
        return service.getAllusers();
    }

    // get a user
    @GetMapping("user/{id}")
    public Optional<User> getUser(@PathVariable("id") long id){
        return service.getUser(id);
    }

    // delete a user
    @GetMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") long id){
         service.deleteUser(id);
    }

    // update a user
 /*  @PutMapping("/update")
    public User updateUser(@RequestBody User user, @PathVariable("id") long id){
        service.update(user, id);
        return user;
    }*/

  /* @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        Optional<User> userData = service.getUser(id);
        if (userData .isPresent()) {
            User u = userData.get();
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            return new ResponseEntity<>(service.saveUser(u), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //pagination

    @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
    Page<User> userPageable(Pageable pageable) {
        return service.find(pageable);

    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserRest> getUsers(@RequestParam (value="page", defaultValue = "0") int page, @RequestParam
            (value = "limit", defaultValue = "4") int limit){
        List<UserRest> userRestList = new ArrayList<UserRest>();

        List<UserDTO> userDTOList = service.getUsers(page, limit);

        for(UserDTO userDTO: userDTOList){
            UserRest userRest = new UserRest();
            BeanUtils.copyProperties(userDTO, userRest);
            userRestList.add(userRest);
        }

        return userRestList;
    }

    // indexing and paging
    @GetMapping("/getall1/{page}")
    public ResponseEntity<Map<String, Object>> getAllUsers1(

            //@RequestParam(defaultValue = "Alamin") String name,
            //@RequestParam int page
           //@RequestParam(defaultValue = "3") int size
            @PathVariable("page") int page){
        List<User> users = new ArrayList<User>();
        Pageable paging = PageRequest.of(page, 3);

        Page<User> pageUsers;
        //if (name == null)
            pageUsers = userRepository.findAll(paging);
        //else
           // pageUsers = userRepository.findByNameContaining(name, paging);
        users = pageUsers.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("users", users);
        response.put("currentPage", pageUsers.getNumber());
        response.put("totalItems", pageUsers.getTotalElements());
        response.put("totalPages", pageUsers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getall2")
    public ResponseEntity<Map<String, Object>> getAllUsers2(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<User> users = new ArrayList<User>();
        Pageable paging = PageRequest.of(page, size);

        Page<User> pageUsers;
        if (name == null)
            pageUsers = userRepository.findAll(paging);
        else
            pageUsers = userRepository.findByNameContaining(name, paging);
        users = pageUsers.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("users", users);
        response.put("currentPage", pageUsers.getNumber());
        response.put("totalItems", pageUsers.getTotalElements());
        response.put("totalPages", pageUsers.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}*/
