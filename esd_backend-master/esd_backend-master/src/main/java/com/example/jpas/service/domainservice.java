package com.example.jpas.service;


import com.example.jpas.domain;
import com.example.jpas.domianrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class domainservice {
    private final domianrepo domianrepo;

    @Autowired
    public domainservice(domianrepo domianrepo) {
        this.domianrepo = domianrepo;
    }

    public List<domain> getAllEntities() {
        return domianrepo.findAll();
    }
}
