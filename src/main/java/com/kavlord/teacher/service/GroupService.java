package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Person;
import com.kavlord.teacher.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GroupService {
    List<Group> findAll();

    Optional<Group> findById(Long id);

    void saveGroup(Group group);

    void saveGroup(Group group, String addTeacher);

    void delete(Long id);

    void removePerson(Group group, Person person);

    void addPerson(Group group, Person person);
}
