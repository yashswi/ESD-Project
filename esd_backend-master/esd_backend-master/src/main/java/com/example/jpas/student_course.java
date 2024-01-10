package com.example.jpas;


import jakarta.persistence.*;

@Entity

    public class student_course {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
        @JoinColumn(name = "student_id")
        private student student;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private course course;

        // Constructors, getters, and setters
    }


