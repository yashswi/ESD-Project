package com.example.jpas.controller;

import com.example.jpas.domain;
import com.example.jpas.service.domainservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class domaincontr {
    private final domainservice domainservice;

    @Autowired
    public domaincontr(domainservice domainservice) {
        this.domainservice = domainservice;
    }

    @GetMapping("/domain")
    public ResponseEntity<List<domain>> getAllEntities() {
        List<domain> entities = domainservice.getAllEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}