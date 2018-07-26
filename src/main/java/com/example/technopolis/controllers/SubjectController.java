package com.example.technopolis.controllers;

import com.example.technopolis.dto.SubjectDto;
import com.example.technopolis.model.Subject;
import com.example.technopolis.model.User;
import com.example.technopolis.services.SubjectRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@RestController
@RequestMapping("/subjects/{id}")
public class SubjectController {

    @Autowired
    private SubjectRepository repository;

    @GetMapping
    public ModelAndView getSubjects(@PathVariable long id) {
        return new ModelAndView("index", Collections.singletonMap("subjects", repository.findAll()));
    }

    @PutMapping
    public Subject insertSubject(@RequestBody SubjectDto subjectDto,@PathVariable long id) {
        return repository.save(new Subject(subjectDto.getInputName()));
    }

    @PostMapping
    public Subject updateSubject(@RequestBody SubjectDto subjectDto,@PathVariable long id) {
        Subject subject = repository.findOne(subjectDto.getInputId());
        subject.setName(subjectDto.getInputName());
        return repository.save(subject);
    }

    @DeleteMapping
    public void deleteSubject(@RequestBody SubjectDto subjectDto) {
        repository.delete(subjectDto.getInputId());
    }
}