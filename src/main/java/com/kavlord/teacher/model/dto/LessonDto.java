package com.kavlord.teacher.model.dto;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LessonDto {
    private Long id;

    private Group group;
    private String date;
    private String description;
    private List<Dancer> presence;
    private List<Teacher> teachers;
}
