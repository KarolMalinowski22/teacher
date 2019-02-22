package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.User;
import com.kavlord.teacher.model.dto.UserDto;
import com.kavlord.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    public String registerForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registerForm";
    }
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(name = "user")UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registerForm";
        }
        User user = userService.register(userDto);
        model.addAttribute("userName", user.getLogin());
        return "registrationSuccessful";
    }
}
