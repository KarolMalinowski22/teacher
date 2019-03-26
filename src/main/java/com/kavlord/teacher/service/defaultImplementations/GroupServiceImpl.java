package com.kavlord.teacher.service.defaultImplementations;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Person;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.repository.GroupRepository;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.TeacherService;
import com.kavlord.teacher.service.utils.EmailValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void saveGroup(Group group, String addTeacher) {
        if ("".equals(addTeacher)) {
            saveGroup(group);
        } else {
            String email = StringUtils.substringBetween(addTeacher, "(", ")");
            if(!EmailValidator.isEmail(email)) throw new IllegalArgumentException("Wygląda na to, że email nauczyciela jest niepoprawny.");
            teacherService.findByEmail(email).ifPresent(e -> {
                List<Teacher> teachers = group.getTeachers();
                if (teachers == null) {
                    teachers = new ArrayList<>();
                }
                teachers.add(e);
                group.setTeachers(teachers);
            });
            saveGroup(group);
        }
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

    private void removeTeacher(Group group, Teacher teacher){
        List<Teacher> teachers = group.getTeachers();
        teachers.remove(teacher);
        group.setTeachers(teachers);
    }
}
