package com.example.technopolis.controllers;

import com.example.technopolis.model.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/")
public class ApiController {

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public List<Subject> getSubjectsr(){
        ArrayList subjects = new ArrayList<Subject>(){{
            add(new Subject(1, "Front-back"));
            add(new Subject(2, "DB"));
            add(new Subject(3, "Advanced java-2"));
        }};

        return subjects;

    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public List<Subject> updateSubjects(){
       //TODO
        return null;

    }

    @RequestMapping(value = "/subjects", method = RequestMethod.DELETE)
    public List<Subject> deleteSubjects(){
        //TODO
        return null;

    }





}
