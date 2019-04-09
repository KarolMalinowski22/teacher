package com.kavlord.teacher.service.defaultImplementation;

import com.kavlord.teacher.model.Lesson;
import com.kavlord.teacher.model.dto.LessonDto;
import com.kavlord.teacher.repository.LessonRepository;
import com.kavlord.teacher.service.LessonService;
import com.kavlord.teacher.service.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Page<Lesson> getAllPaginated(Pageable pageable, String sortMethod) {
        Comparator<Lesson> comparator = getComparator(sortMethod);
        Page<Lesson> page = PageUtils.getPageSorted(pageable, getAll(), comparator);
        return page;
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    @Override
    public void save(LessonDto lessonDto) {
        throw new NotImplementedException();
    }

    private Comparator<Lesson> getComparator(String sortMethod){
        switch (sortMethod){
            default: return Comparator.comparing(Lesson::getDate).reversed();
        }
    }
}
