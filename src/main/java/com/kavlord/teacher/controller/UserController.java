package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.User;
import com.kavlord.teacher.model.dto.UserDto;
import com.kavlord.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    Integer defaultSize = 20;

    @RequestMapping("/register")
    public String registerForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "forms/registerForm";
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
    @RequestMapping("/users")
    public String displayAllUsers(Model model, @RequestParam("page") Optional<Integer> pageOpt, @RequestParam("size") Optional<Integer> sizeOpt){
        Integer page = pageOpt.orElse(1);
        Integer size = sizeOpt.orElse(defaultSize);
        Page<User> userPage = userService.getAllPaginated(PageRequest.of(page - 1, size));
        model.addAttribute("userPage", userPage);
        Integer totalPages = userPage.getTotalPages();
        if(totalPages > 0){
            List<Integer> pagesNumbersList = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pagesNumbersList", pagesNumbersList);
        }
        return "users";
    }
    @RequestMapping("/user/details")
    public String userDetailed(Model model, @RequestParam("id")Long userId){
        Optional<User> optUser = userService.findUserById(userId);
        if(optUser.isPresent()){
            model.addAttribute("user", optUser.get());
            return "userDetails";
        }else{
            return "redirect:/users";
        }
    }
}
