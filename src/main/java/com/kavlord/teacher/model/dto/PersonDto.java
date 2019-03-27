package com.kavlord.teacher.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String groupsDto;
}
