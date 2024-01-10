package com.example.jpas.service;
import com.example.jpas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final courserepo courserepo;


    @Autowired
    public CourseService(courserepo courserepo) {
        this.courserepo = courserepo;

    }

    public List<course> getAllCourses() {
        return courserepo.findAll();
    }
    public faculty getFacultyByCourseId(Long courseId) {
        Optional<course> courseOptional = courserepo.findById(courseId);

        return courseOptional.map(course -> course.getFaculty()).orElse(null);
    }
    public schedule getScheduleByCourseId(Long courseId) {
        Optional<course> courseOptional = courserepo.findById(courseId);

        return courseOptional.map(course::getSchedule).orElse(null);
    }




}
