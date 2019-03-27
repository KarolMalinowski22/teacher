package com.kavlord.teacher.service.utils;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.GroupDto;

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
}
