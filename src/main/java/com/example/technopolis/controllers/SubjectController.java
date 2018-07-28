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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class SubjectController {

    @Autowired
    private SubjectRepository repository;

    @GetMapping("/subjects/{id}")
    public ModelAndView getSubjects() {
        return new ModelAndView("index");
    }

    @GetMapping("/subjects/{id}/getAll")
    public Iterable<Subject> getAll(@PathVariable long id) {
        List<Subject> list = new ArrayList<>();
        for (Subject subject : repository.findAll()) {
            if (subject.getUser().getId() == id) {
                list.add(subject);
            }
        }
        return list;
    }

    @PutMapping("/subjects/{id}")
    public Subject insertSubject(@RequestBody SubjectDto subjectDto, @PathVariable long id) {
        return repository.save(new Subject(subjectDto.getInputName(), id));
    }

    @PostMapping("/subjects/{id}")
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

    @DeleteMapping("/subjects/{id}")
    public void deleteSubject(@RequestBody SubjectDto subjectDto, @PathVariable long id) {
        for (Subject subject : repository.findAll()) {
            if (subject.getUser().getId() == id) {
                if (Objects.equals(subject.getId(), subjectDto.getInputId())) {
                    repository.delete(subjectDto.getInputId());
                    return;
                }
            }
        }
        throw new EntityNotFoundException();
    }
}