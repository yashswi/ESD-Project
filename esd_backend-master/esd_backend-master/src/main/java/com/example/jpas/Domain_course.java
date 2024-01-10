package com.example.jpas;

import jakarta.persistence.*;

@Entity

    public class Domain_course {
        public Domain_course(){
            super();
        }
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private int id;

        @ManyToOne
        @JoinColumn(name = "domain_id")
        private domain domain;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private course course;

    public course getCourse() {
        return course;
    }


    // Constructors, getters, and setters
    }


