package com.kavlord.teacher.service.defaultImplementation;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.model.dto.PersonDto;
import com.kavlord.teacher.repository.TeacherRepository;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.TeacherService;
import com.kavlord.teacher.service.utils.PersonMap;
import com.kavlord.teacher.service.utils.DtoExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private GroupService groupService;
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void save(PersonDto personDto) {
        String groupsIdsString = personDto.getGroupsDto();

        List<Group> groups = PersonMap.fromIds(groupsIdsString, groupService);
        Teacher teacher = DtoExtractor.getTeacher(personDto, groups);

        findById(personDto.getId())
                .ifPresent(e -> {
                    teacher.setLessons(e.getLessons());
                    teacher.setUser(e.getUser());
                });

        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Optional<Teacher> findByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }
}
