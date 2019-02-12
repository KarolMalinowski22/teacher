package com.kavlord.teacher.repository;

import com.kavlord.teacher.model.Dancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DancerRepository extends JpaRepository<Dancer, Long> {
}
