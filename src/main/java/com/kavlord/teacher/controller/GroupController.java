package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.GroupDto;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    /**
     *
     * @param id of group to show and modify
     */
    @RequestMapping("/details")
    public String showGroupDetails(@ModelAttribute("id") Long id, Model model){

        editGroup(model, groupService.findById(id).get());

        return "groupDetails";
    }
    @RequestMapping("/addGroup")
    public String addGroup(Model model){
        editGroup(model, new Group());

        return "groupDetails";
    }
    @RequestMapping("/save")
    public String saveGroup(@ModelAttribute("teacherTransporter") String teacherTransporter,
                            @ModelAttribute("group") Group group,
                            @ModelAttribute("groupDto") GroupDto groupDto,
                            Model model){
        groupService.saveGroup(groupDto);
        return "redirect:/groups";
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("id") Long id){
        groupService.delete(id);
        return "redirect:/groups";
    }

    private void editGroup(Model model, Group group){
        model.addAttribute("allTeachers", teacherService.findAll());
        model.addAttribute("groups", groupService.findAll());

        model.addAttribute("group", group);
        model.addAttribute("groupDto", new GroupDto());
    }
}
