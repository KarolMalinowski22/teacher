package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Lesson;
import com.kavlord.teacher.model.dto.LessonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    List<Lesson> getAll();

    Page<Lesson> getAllPaginated(Pageable pageable, String sortMethod);

    Optional<Lesson> findById(Long id);

    void save(LessonDto lessonDto);
}
