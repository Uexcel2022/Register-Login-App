package com.uexcel.registerloginapp.controller;

import com.uexcel.registerloginapp.entity.dto.UserDto;
import com.uexcel.registerloginapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {
    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "registrationPage";
    }

    @PostMapping("/register")
    String saveUser(@ModelAttribute("user") UserDto userDto, Model model){
        if(!userDto.getPassword1().equals(userDto.getPassword2())){
            model.addAttribute("error","The password did not match!");
            return "registrationPage";
        }
        model.addAttribute("success","You have been registered successfully!");
        userService.saveUser(userDto);
        return "registrationPage";
    }
}
