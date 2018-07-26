package com.example.technopolis.controllers;

import com.example.technopolis.dto.SubjectDto;
import com.example.technopolis.model.Subject;
import com.example.technopolis.services.SubjectRepository;
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

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/subjects/{id}")
public class SubjectController {

    @Autowired
    private SubjectRepository repository;

    @GetMapping
    public ModelAndView getSubjects(@PathVariable long id) {
        List<Subject> list = new ArrayList<>();
        for (Subject subject : repository.findAll()) {
            if (subject.getUser().getId() == id) {
                list.add(subject);
            }
        }
        return new ModelAndView("index", Collections.singletonMap("subjects", list));
    }

    @PutMapping
    public Subject insertSubject(@RequestBody SubjectDto subjectDto, @PathVariable long id) {
        return repository.save(new Subject(subjectDto.getInputName(), id));
    }

    @PostMapping
    public Subject updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable long id) {
        for (Subject subject : repository.findAll()) {
            if (subject.getUser().getId() == id) {
                if (Objects.equals(subject.getId(), subjectDto.getInputId())) {
                    subject.setName(subjectDto.getInputName());
                    return repository.save(subject);
                }
            }
        }
        throw new EntityNotFoundException();
    }

    @DeleteMapping
    public void deleteSubject(@RequestBody SubjectDto subjectDto, @PathVariable long id) {
        for (Subject subject : repository.findAll()) {
            if (subject.getUser().getId() == id) {
                if (Objects.equals(subject.getId(), subjectDto.getInputId())) {
                    repository.delete(subjectDto.getInputId());
                }
            }
        }
        throw new EntityNotFoundException();
    }
}