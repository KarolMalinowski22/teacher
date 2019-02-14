package com.kavlord.teacher.service;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.repository.DancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class DancerServiceImpl implements DancerService {
    @Autowired
    DancerRepository dancerRepository;
    @Override
    public List<Dancer> findAll() {
        return dancerRepository.findAll();
    }

    @Override
    public List<Dancer> findAllActive(){
        throw new NotImplementedException();
    }

    @Override
    public Dancer update(Dancer dancer) {
        return dancerRepository.save(dancer);
    }

    @Override
    public Optional<Dancer> findById(Long id) {
        return dancerRepository.findById(id);
    }

}
