package com.example.jpas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Domain_courserepo extends JpaRepository<Domain_course,Integer> {
    List<Domain_course> findByDomainId(int domain_id);
}
