package com.kavlord.teacher.controller;

import com.kavlord.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @RequestMapping
    public String teachers(Model model){
        model.addAttribute("people", teacherService.findAll());
        return "people";
    }

}
