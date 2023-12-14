package com.uexcel.registerloginapp.controller;

import com.uexcel.registerloginapp.entity.User;
import com.uexcel.registerloginapp.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserLoginController {

    private final UserDetailsService userDetailsService;

    public UserLoginController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @GetMapping("/login")
      public  String login(){
        return "login-page";
    }

    @GetMapping("/user-page")
    public String user(Model model, Principal principal) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user.getFullName());
        return "userPage";
    }

    @GetMapping("/admin-page")
    public String admin(Model model, Principal principal) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user.getFullName());
        return "adminPage";
    }


}