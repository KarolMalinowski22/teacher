package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.service.DancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dancer")
public class DancerController {
    @Autowired
    DancerService dancerService;
    @RequestMapping
    public String showAllDancers(Model model){
        model.addAttribute("dancers", dancerService.findAll());
        return "dancers";
    }
    @PostMapping("/update")
    public String updateDancer(Model model, @ModelAttribute(name = "dancer")Dancer dancer){
        model.addAttribute("isUpdating", Boolean.TRUE);
        model.addAttribute("dancer", dancer);
        return "dancerDetails";
    }
}
