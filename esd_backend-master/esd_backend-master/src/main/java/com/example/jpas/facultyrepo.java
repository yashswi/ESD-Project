package com.example.jpas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface facultyrepo extends JpaRepository<faculty,Integer> {
    Optional<faculty> findById(int id);
}
