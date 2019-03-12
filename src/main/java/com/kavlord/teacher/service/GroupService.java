package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GroupService {
    List<Group> findAll();

    Optional<Group> findById(Long id);

    void saveGroup(Group group);
}
