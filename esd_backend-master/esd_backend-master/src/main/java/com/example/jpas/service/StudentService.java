package com.example.jpas.service;

import com.example.jpas.student;
import com.example.jpas.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final studentrepo studentrepo;

    @Autowired
    public StudentService(studentrepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    public List<student> getStudentsByCourseId(Long courseId) {
        return studentrepo.findByCoursesId(courseId);
    }

    // Other methods...

}
