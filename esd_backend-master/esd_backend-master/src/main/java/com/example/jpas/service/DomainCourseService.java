package com.example.jpas.service;
import com.example.jpas.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jpas.Domain_courserepo;
import com.example.jpas.Domain_course;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainCourseService {
    private final Domain_courserepo Domain_courserepo;

    @Autowired
    public DomainCourseService(Domain_courserepo Domain_courserepo) {
        this.Domain_courserepo = Domain_courserepo;
    }

    public List<course> getCoursesByDomainId(int domainId) {
        List<Domain_course> domainCourses = Domain_courserepo.findByDomainId(domainId);
        return domainCourses.stream().map(Domain_course::getCourse).collect(Collectors.toList());
    }
}

