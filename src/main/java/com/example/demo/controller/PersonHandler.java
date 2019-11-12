package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")

public class PersonHandler {
//    @Autowired
//    PersonService ps;
    //we can ignore service level

    @Autowired
    PersonRepo repo;

    @GetMapping("/")
//    @ResponseBody
    //http://localhost:8081/person
    public List<Person> getAll() {
        List<Person> p = (List<Person>) repo.findAll();
        p.forEach(i -> System.out.println(i));
        return p;
    }

    @GetMapping("/{id}")
//    @ResponseBody
    //http://localhost:8081/person/2
    public Person getOne(@PathVariable int id) {
        return repo.findById(id).orElse(new Person()); //Optional return of findByID
    }

    @PostMapping("/")
    //@Transactional  //no need to transaction because it is one step!!!!!!
    public ResponseEntity add(@RequestBody Person person) {

        return ResponseEntity.ok(repo.save(person));
    }

    @PutMapping("/{id}")
    @Transactional  //do not forget when you want to persist changes on attached obj!!!!!!!!!!
    public ResponseEntity change(@RequestBody Person person, @PathVariable int id) {

        Optional<Person> p=repo.findById(id);
        if(p.isPresent())
        {
            p.get().setName(person.getName()); //it automatically change, if we use save, it creates new obj!
            return ResponseEntity.ok("changed");
        }
        else
//            return ResponseEntity.notFound().build();  //diff ways
            return ResponseEntity.status(400).body("no Data to change");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete( @PathVariable int id) {

        if (repo.existsById(id)) {
            System.out.println(id);
            repo.deleteById(id);
            return ResponseEntity.ok("deleted");
        }
        else  //diff ways
//            return ResponseEntity.notFound().build();
//         new ResponseEntity<>("Oracle Problem", HttpStatus.SERVICE_UNAVAILABLE)
            return ResponseEntity.status(400).body("no Data to delete");

    }
}
