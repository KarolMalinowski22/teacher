package com.kavlord.teacher.model.dto;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GroupDto {
    private Long id;
    private String name;
    private String town;
    private String address;
    private String description;
    private List<Teacher> teachers;
}
