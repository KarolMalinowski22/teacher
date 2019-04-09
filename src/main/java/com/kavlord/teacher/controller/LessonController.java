package com.kavlord.teacher.controller;

import com.kavlord.teacher.model.Lesson;
import com.kavlord.teacher.model.dto.LessonDto;
import com.kavlord.teacher.service.DancerService;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.LessonService;
import com.kavlord.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    int defaultPageSize = 20;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DancerService dancerService;

    @RequestMapping
    public String showAllLessons(Model model, @RequestParam(name = "page")Optional<Integer> pageOpt, @RequestParam(name = "size")Optional<Integer> sizeOpt){
        Optional<String> sortMethodOpt = Optional.empty();
        Integer page = pageOpt.orElse(1);
        Integer size = sizeOpt.orElse(defaultPageSize);
        String sortMethod = sortMethodOpt.orElse("default");
        Page<Lesson> lessonsPage = lessonService.getAllPaginated(PageRequest.of(page - 1, size), sortMethod);
        model.addAttribute("lessons", lessonsPage);
        model.addAttribute("groups", groupService.findAll());
        Integer totalPages = lessonsPage.getTotalPages();
        if(totalPages > 0){
            List<Integer> pagesNumbersList = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pagesNumbersList", pagesNumbersList);
        }
        return "lessons";
    }
    @RequestMapping("/details")
    public String showGroupDetails(@ModelAttribute("id") Long id, Model model){

        editLesson(model, lessonService.findById(id).get());

        return "lessonDetails";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute("lessonDto")LessonDto lessonDto){
        lessonService.save(lessonDto);
        return "redirect:/lessons";
    }


    private void editLesson(Model model, Lesson lesson){
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("allTeachers", teacherService.findAll());
        model.addAttribute("lesson", lesson);
        model.addAttribute("groupDancers", dancerService.findAllByGroup(lesson.getGroup()));
        model.addAttribute("lessonDto", new LessonDto());
    }
}
