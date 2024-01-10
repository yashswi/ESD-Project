package com.example.jpas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface schedulerepo extends JpaRepository<schedule,Integer> {
    Optional<schedule> findByCourseId(Long courseId);

}
