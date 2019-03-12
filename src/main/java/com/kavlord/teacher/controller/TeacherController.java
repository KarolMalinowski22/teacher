package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Person;
import com.kavlord.teacher.model.Teacher;
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
    @RequestMapping
    public String teachers(Model model){
        model.addAttribute("objectTypeName", "Teacher");
        model.addAttribute("people", teacherService.findAll());
        return "people";
    }
    @RequestMapping("/addNewTeacher")
    public String addNewDancerForm(Model model){
        model.addAttribute("teacher", new Teacher());
        return "forms/addNewTeacherForm";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute(name = "person")Teacher teacher){
            teacherService.save(teacher);
        return "redirect:/teachers";
    }
    @RequestMapping("delete")
    public String delete(@ModelAttribute(name = "id")Long id){
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        teacherOptional.ifPresent(teacher -> teacherService.delete(teacher));
        return "redirect:/teachers";
    }
}
