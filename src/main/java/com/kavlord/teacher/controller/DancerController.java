package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.service.DancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
    public String updateDancer(Model model, @RequestParam(name = "id")Long id){
        Optional<Dancer> optionalDancer = dancerService.findById(id);
        if(optionalDancer.isPresent()){
            model.addAttribute("isUpdating", Boolean.TRUE);
            model.addAttribute("dancer", optionalDancer.get());
            return "dancerDetails";
        }else{
            //todo: displaying error for user
            return "redirect:/dancer";
        }
    }
}
