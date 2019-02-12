package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Dancer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DancerService {
    List<Dancer> findAll();
    List<Dancer> findAllActive();
    Dancer update(Dancer dancer);
}
