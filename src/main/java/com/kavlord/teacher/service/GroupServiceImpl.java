package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.Teacher;
import com.kavlord.teacher.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;
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
}
