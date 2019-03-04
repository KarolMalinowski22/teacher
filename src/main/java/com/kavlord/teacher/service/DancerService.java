package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Dancer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DancerService {
    List<Dancer> findAll();
    List<Dancer> findAllActive();
    Dancer update(Dancer dancer);
    Optional<Dancer> findById(Long id);

    void save(Dancer dancer);

    void delete(Long id);
}
