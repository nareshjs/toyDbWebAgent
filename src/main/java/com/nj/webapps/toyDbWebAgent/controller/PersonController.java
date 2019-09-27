package com.nj.webapps.toyDbWebAgent.controller;

import com.nj.webapps.toyDbWebAgent.entity.Person;
import com.nj.webapps.toyDbWebAgent.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController
{
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public Person create(@RequestBody Person person)
    {
        return personRepository.save(person);
    }

    @GetMapping("/persons")
    public List<Person> findAll()
    {
        return personRepository.findAll();
    }

    @PutMapping("/persons/{person_id}")
    public Person update(@PathVariable("person_id") Integer personId, @RequestBody Person personObject)
    {
        Person person = personRepository.findById(personId).get();
        person.setFirstName(personObject.getFirstName());
        person.setAge(personObject.getAge());
        return personRepository.save(person);
    }

    @DeleteMapping("/persons/{person_id}")
    public List<Person> delete(@PathVariable("person_id") Integer personId)
    {
        Person person = personRepository.findById(personId).get();
        personRepository.delete(person);
        return personRepository.findAll();
    }

    @GetMapping("/persons/{person_id}")
    public Person findByPersonId(@PathVariable("person_id") Integer personId)
    {
        return personRepository.findById(personId).get();
    }
}
