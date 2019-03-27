package com.kavlord.teacher.service.utils;

import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.service.TeacherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupMap {
    public static List<Teacher> fromIds(String ids, TeacherService teacherService){
        List<Teacher> teachers = new ArrayList<>();
        if(!"".equals(ids)) {
            teachers = Arrays.stream(ids.split(","))
                    .map(_string -> Long.valueOf(_string))
                    .map(_long -> teacherService.findById(_long))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
        return teachers;
    }
}
