package com.kavlord.teacher.controller;

import com.kavlord.teacher.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @Autowired
    GroupService groupService;
    @RequestMapping("/")
    public String goHome(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "home";
    }
}
