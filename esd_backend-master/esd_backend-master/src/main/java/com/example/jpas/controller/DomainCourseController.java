package com.example.jpas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.jpas.service.DomainCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.example.jpas.course;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000/")
public class DomainCourseController {
    private final DomainCourseService domainCourseService;

    @Autowired
    public DomainCourseController(DomainCourseService domainCourseService) {
        this.domainCourseService = domainCourseService;
    }

    @GetMapping("/byDomain/{domainId}")
    public ResponseEntity<List<course>> getCoursesByDomain(@PathVariable int domainId) {
        List<course> courses = domainCourseService.getCoursesByDomainId(domainId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}

