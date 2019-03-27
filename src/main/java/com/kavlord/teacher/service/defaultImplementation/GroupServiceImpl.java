package com.kavlord.teacher.service.defaultImplementation;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Person;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.GroupDto;
import com.kavlord.teacher.repository.GroupRepository;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.TeacherService;
import com.kavlord.teacher.service.utils.DtoExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private TeacherService teacherService;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void saveGroup(Group group) {
         groupRepository.save(group);
    }

    @Override
    public void saveGroup(Group group, String teacherTransporter) {

    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void removePerson(Group group, Person person) {
        if(person instanceof Teacher){
            removeTeacher(group, (Teacher)person);
        }
    }

    @Override
    public void addPerson(Group group, Person person) {

    }

    @Override
    public void saveGroup(GroupDto groupDto) {
        String teachersString = groupDto.getTeachers();

        List<Teacher> teachers = new ArrayList<>();
        if(!"".equals(teachersString)) {
            teachers = Arrays.stream(teachersString.split(","))
                    .map(_string -> Long.valueOf(_string))
                    .map(_long -> teacherService.findById(_long))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
        Group group = DtoExtractor.getGroup(groupDto, teachers);
        saveGroup(group);
    }

    private void removeTeacher(Group group, Teacher teacher){
        List<Teacher> teachers = group.getTeachers();
        teachers.remove(teacher);
        group.setTeachers(teachers);
    }
}
