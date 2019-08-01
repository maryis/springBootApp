package com.example.demo.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface PersonRepo extends CrudRepository<Person,Integer> {

    List<Person> findTopByIdBefore(int id);
    void removeFirstByNameAndAndId(String name,int i);

    void deleteAllByNameContains(String str);

}
