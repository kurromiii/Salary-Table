package com.mftplus.salary.service;

import com.mftplus.salary.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void save(Person person) throws Exception;
    void edit(Person person) throws Exception;
    void logicalRemove(Long id) throws Exception;

    List<Person> findAll() throws Exception;
    List<Person> findAllByDeletedFalse() throws Exception;

    Optional<Person> findById(Long id) throws Exception;

    List<Person> findPersonByNameAndLastnameAndDeletedFalse(String name , String lastName) throws Exception;
}
