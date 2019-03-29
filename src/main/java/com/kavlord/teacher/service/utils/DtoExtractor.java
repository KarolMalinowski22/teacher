package com.kavlord.teacher.service.utils;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.GroupDto;
import com.kavlord.teacher.model.dto.PersonDto;

import java.util.List;

public class DtoExtractor {
    /**
     *
     * @param groupDto
     * @param teachers is List of teachers extracted from groupDto.teachers String
     * @return
     */
    public static Group getGroup(GroupDto groupDto, List<Teacher> teachers){
        Group group = new Group();
        group.setAddress(groupDto.getAddress());
        group.setDescription(groupDto.getDescription());
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        group.setTown(groupDto.getTown());
        group.setTeachers(teachers);
        return group;
    }

    /**
     *
     * @param personDto
     * @param groups is List of teachers extracted from groupDto.teachers String
     * @return
     */
    public static Dancer getDancer(PersonDto personDto, List<Group> groups){
        Dancer dancer = new Dancer();
        dancer.setFirstName(personDto.getFirstName());
        dancer.setLastName(personDto.getLastName());
        dancer.setId(personDto.getId());
        dancer.setEmail(personDto.getEmail());
        dancer.setPhoneNumber(personDto.getPhoneNumber());
        dancer.setGroups(groups);
        dancer.setBirthDate(personDto.getBirthDate());
        return dancer;
    }

    public static Teacher getTeacher(PersonDto personDto, List<Group> groups) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(personDto.getFirstName());
        teacher.setLastName(personDto.getLastName());
        teacher.setId(personDto.getId());
        teacher.setEmail(personDto.getEmail());
        teacher.setPhoneNumber(personDto.getPhoneNumber());
        teacher.setGroups(groups);
        teacher.setBirthDate(personDto.getBirthDate());
        return teacher;
    }
}
