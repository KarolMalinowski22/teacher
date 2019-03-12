package com.kavlord.teacher.repository;

import com.kavlord.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
