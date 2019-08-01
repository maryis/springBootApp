package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonService {

    @Autowired
    PersonRepo prepo;

    public List<Person> getAll(){
        return (List<Person>) prepo.findAll();
    }



}
