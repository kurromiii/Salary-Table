package com.mftplus.salary.controller;

import com.mftplus.salary.model.Person;
import com.mftplus.salary.service.impl.PersonServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    //person table
    @GetMapping("/personTable")
    public String showSalaryList(Model model){
        log.info("Person Table - Get");
        try {
            model.addAttribute("person", new Person());
            model.addAttribute("personList", personService.findAllByDeletedFalse());
            return "personTable";
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //person form
    @GetMapping("/personForm")
    public String showForm(Model model) {
        log.info("Person Form - Get");
        try {
            model.addAttribute("person", new Person());
            return "personForm";
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //person save
    @PostMapping(value = "/save")
    public String save(@Valid Person person, BindingResult result, Model model){
        log.info("Person Save - Post");
        if (result.hasErrors()){
            log.error(result.getAllErrors().toString());
            return "personForm";
        }
        try {
            personService.save(person);
            log.info("Person Saved");
            log.info(person.toString());
            model.addAttribute("person", new Person());
            model.addAttribute("msg", "Person Saved");
            return "redirect:/person/personTable";
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
