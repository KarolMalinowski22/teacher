package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Person;
import com.kavlord.teacher.model.dto.PersonDto;
import com.kavlord.teacher.service.DancerService;
import com.kavlord.teacher.service.GroupService;
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
    @Autowired
    GroupService groupService;
    @RequestMapping
    public String showAllDancers(Model model){
        model.addAttribute("objectTypeName", "Dancer");
        model.addAttribute("people", dancerService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "people.html";
    }
    @RequestMapping("/group")
    public String showGroup(Model model, @ModelAttribute("groupId")Long groupId){
        model.addAttribute("objectTypeName", "Dancer");
        model.addAttribute("people", dancerService.findByGroup(groupService.findById(groupId).get()));
        model.addAttribute("groups", groupService.findAll());
        return "people.html";
    }
    @RequestMapping("/details")
    public String dancerDetailed(Model model, @RequestParam(name = "id")Long id){
        Optional<Dancer> optionalDancer = dancerService.findById(id);
        if(optionalDancer.isPresent()){
            model.addAttribute("person", optionalDancer.get());
            model.addAttribute("allGroups", groupService.findAll());
            model.addAttribute("personDto", new PersonDto());
            return "dancerDetails";
        }else{
            //todo: displaying error for user
            return "redirect:/dancers";
        }
    }
    @RequestMapping("/addNewDancer")
    public String addNewDancerForm(Model model){
        model.addAttribute("dancer", new Dancer());
        return "forms/addNewDancerForm";
    }
    @PostMapping("/save")
    public String saveDancer(Model model, @ModelAttribute("personDto") PersonDto personDto, @ModelAttribute("dancer")Dancer dancer){
        dancerService.save(personDto);
        return "redirect:/dancers";
    }
    @RequestMapping("/delete")
    public String deleteDancer(Model model, @ModelAttribute("id")Long id){
        dancerService.delete(id);
        return "redirect:/dancers";
    }
}
