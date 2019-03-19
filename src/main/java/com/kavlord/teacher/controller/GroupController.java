package com.kavlord.teacher.controller;

import com.kavlord.teacher.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @RequestMapping()
    public String showGroups(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }
    @RequestMapping("/details")
    public String showGroupDetails(@ModelAttribute Long id, Model model){
        model.addAttribute("group", groupService.findById(id));
        model.addAttribute("groups", groupService.findAll());
        return "groupDetails";
    }
}
