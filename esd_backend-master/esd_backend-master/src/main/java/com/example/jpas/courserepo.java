package com.example.jpas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface courserepo extends JpaRepository<course,Long> {

    Optional<course> findById(Long id);

}
