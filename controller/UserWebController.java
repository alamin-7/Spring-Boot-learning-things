package com.example.User.controller;

import com.example.User.service.Services;
import com.example.User.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserWebController {

    @Autowired
    private Services service;

    // welcome page
    @GetMapping("/")
    public String welcomePage(Model model){
        return userPaginated(1, "name", "asc", model);
    }

    // showing signup form
    @GetMapping("/signup")
    public String showSignUpForm(User user){
        return "add_users";
    }

    // creating users
    @PostMapping("/adduser")
    public RedirectView addUser(User user, Model model){
        System.out.println(user);
        service.saveUser(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/index");
        return redirectView;
    }

    //get all users

    /*@GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", service.getAllusers());
        return "showall";
    }*/

    // show update form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        //System.out.println(id);
        User user = service.getUser(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_user";
    }

    // update saving
    @PostMapping("/update/{id}")
    public RedirectView updateUser(@PathVariable("id") long id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
          //  return "update-user";
        }
        service.saveUser(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/index");
        return redirectView;
    }

    // delete user

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = service.getUser(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        service.deleteUser(id);
        return "redirect:/showall";
    }

    // pagination and sorting

    @GetMapping("/page/{pageNo}")
    public String userPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam(value = "sortField") String sortField,
                                @RequestParam(value = "sortDir") String sortDir,
                                Model model){
        int pageSize = 3;
        Page<User> page = service.userPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listOfUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listUsers", listOfUsers);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseDirection", sortDir.equals("asc") ? "desc" : "asc");

        return "showall";
    }
}
