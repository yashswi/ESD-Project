package com.example.jpas.service;

// ScheduleService.java
import com.example.jpas.schedulerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jpas.schedule;
import java.util.Optional;

@Service
public class ScheduleService {

    private final schedulerepo schedulerepo;

    @Autowired
    public ScheduleService(schedulerepo schedulerepo) {
        this.schedulerepo= schedulerepo;
    }

    public Long getScheduleIdByCourseId(Long courseId) {
        Optional<schedule> scheduleOptional = schedulerepo.findByCourseId(courseId);
        return scheduleOptional.map(schedule::getId).orElse(null);
    }

    // Other methods for CRUD operations...

}
