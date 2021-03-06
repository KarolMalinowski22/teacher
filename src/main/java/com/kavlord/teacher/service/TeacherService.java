package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.PersonDto;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> findAll();

    void save(PersonDto personDto);

    void delete(Teacher person);

    Optional<Teacher> findById(Long id);

    Optional<Teacher> findByEmail(String email);
}
