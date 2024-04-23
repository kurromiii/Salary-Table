package com.mftplus.salary.service.impl;

import com.mftplus.salary.model.Person;
import com.mftplus.salary.repository.PersonRepository;
import com.mftplus.salary.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) throws Exception {
        personRepository.save(person);
    }

    @Override
    public void edit(Person person) throws Exception {
        personRepository.save(person);
    }

    @Override
    public void logicalRemove(Long id) throws Exception {
        personRepository.logicalRemove(id);
    }

    @Override
    public List<Person> findAll() throws Exception {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findAllByDeletedFalse() throws Exception {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) throws Exception {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findByNameOrFamily(String name, String family) throws Exception {
        return personRepository.findByNameOrFamily(name,family);
    }
}
