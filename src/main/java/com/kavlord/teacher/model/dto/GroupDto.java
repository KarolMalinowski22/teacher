package com.kavlord.teacher.model.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class GroupDto {
    private Long id;
    private String name;
    private String town;
    private String address;
    private String description;
    private String teachers;
}
