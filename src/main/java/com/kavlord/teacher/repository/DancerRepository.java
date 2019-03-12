package com.kavlord.teacher.repository;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DancerRepository extends JpaRepository<Dancer, Long> {
    List<Dancer> findAllByGroupsContains(Group group);
}
