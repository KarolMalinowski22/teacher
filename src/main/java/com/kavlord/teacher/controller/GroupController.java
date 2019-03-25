package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.TeacherService;
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
    @Autowired
    TeacherService teacherService;

    @RequestMapping
    public String showGroups(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }
    @RequestMapping("/details")
    public String showGroupDetails(@ModelAttribute("id") Long id, Model model){
        model.addAttribute("group", groupService.findById(id).get());
        model.addAttribute("allTeachers", teacherService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "groupDetails";
    }
    @RequestMapping("/save")
    public String saveGroup(@ModelAttribute("group") Group group,@ModelAttribute("addTeacher") String addTeacher, Model model){

        groupService.saveGroup(group, addTeacher);
        return "redirect:/groups";
    }
    @RequestMapping("/delete")
    public String delete(@ModelAttribute("id") Long id){
        groupService.delete(id);
        return "redirect:/groups";
    }
}
