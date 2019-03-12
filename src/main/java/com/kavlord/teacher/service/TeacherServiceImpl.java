package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
