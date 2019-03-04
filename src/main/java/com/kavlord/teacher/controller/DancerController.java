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
@RequestMapping("/dancers")
public class DancerController {
    @Autowired
    DancerService dancerService;
    @RequestMapping
    public String showAllDancers(Model model){
        model.addAttribute("dancers", dancerService.findAll());
        return "dancers.html";
    }
    @RequestMapping("/details")
    public String dancerDetailed(Model model, @RequestParam(name = "id")Long id){
        Optional<Dancer> optionalDancer = dancerService.findById(id);
        if(optionalDancer.isPresent()){
            model.addAttribute("isUpdating", Boolean.TRUE);
            model.addAttribute("dancer", optionalDancer.get());
            return "dancerDetails";
        }else{
            //todo: displaying error for user
            return "redirect:/dancers";
        }
    }
    @RequestMapping("/addNewDancer")
    public String addNewDancerForm(Model model){
        model.addAttribute("dancer", new Dancer());
        return "addNewDancerForm";
    }
    @PostMapping("/saveDancer")
    public String saveDancer(Model model, @ModelAttribute("dancer")Dancer dancer){
        dancerService.save(dancer);
        return "redirect:/dancers";
    }
    @RequestMapping("/delete")
    public String deleteDancer(Model model, @ModelAttribute("id")Long id){
        dancerService.delete(id);
        return "redirect:/dancers";
    }
}
