package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DancerService {
    List<Dancer> findAll();

    List<Dancer> findAllActive();

    Dancer update(Dancer dancer);

    Optional<Dancer> findById(Long id);

    void save(PersonDto personDto);

    void delete(Long id);

    List<Dancer> findByGroup(Group group);

    List<Dancer> findAllByGroup(Group group);
}
