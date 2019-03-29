package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.PersonDto;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    GroupService groupService;
    @RequestMapping
    public String teachers(Model model){
        model.addAttribute("objectTypeName", "Teacher");
        model.addAttribute("people", teacherService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "people";
    }
    @RequestMapping("/details")
    public String detailed(@ModelAttribute("id")Long id, Model model){
        Optional<Teacher> optionalTeacher = teacherService.findById(id);
        if(optionalTeacher.isPresent()) {
            model.addAttribute("person", teacherService.findById(id).get());
            model.addAttribute("allGroups", groupService.findAll());
            model.addAttribute("personDto", new PersonDto());
            return "teacherDetails";
        }else{
            model.addAttribute("errorMessage", "Coś się popsuło. Nie można wczytać danych nauczyciela.");
            return "redirect:/people";
        }
    }
    @RequestMapping("/addNewTeacher")
    public String addNewDancerForm(Model model){
            model.addAttribute("person", Teacher.empty());
            model.addAttribute("allGroups", groupService.findAll());
            model.addAttribute("personDto", new PersonDto());
            return "teacherDetails";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute(name = "personDto")PersonDto personDto){
            teacherService.save(personDto);
        return "redirect:/teachers";
    }
    @RequestMapping("/delete")
    public String delete(@ModelAttribute(name = "id")Long id){
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        teacherOptional.ifPresent(teacher -> teacherService.delete(teacher));
        return "redirect:/teachers";
    }
    @RequestMapping("/removeTeacher")
    public String removeTeacher(@ModelAttribute("group") Group group, @ModelAttribute(name = "teachersId")Long id){
        groupService.removePerson(group, teacherService.findById(id).get());
        return "redirect:/details";
    }
}
