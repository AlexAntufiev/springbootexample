package com.example.technopolis.controllers;

import com.example.technopolis.dto.SubjectDto;
import com.example.technopolis.model.Subject;
import com.example.technopolis.services.NewSubjectRepository;
import com.example.technopolis.services.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@RestController
@RequestMapping(
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class ApiController {

    @Autowired
    SubjectsRepository subjectsRepository;

    @Autowired
    NewSubjectRepository newSubjectsRepository;

    @GetMapping("/subjects")
    @ResponseBody
    public ModelAndView getSubjects() {
        return new ModelAndView("index1", Collections.singletonMap("subject", newSubjectsRepository.findAll()));
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    //    @GetMapping("/")
    //    public ModelAndView mainPage() {
    //        //        repository.updateScore();
    //        Map<String, String> model = new HashMap<>();
    //        //        model.put("score", String.valueOf(repository.getScore().getScore()));
    //        return new ModelAndView("index1", model);
    //    }

    @PutMapping("/subjects")
    public long insertSubject(@RequestBody SubjectDto subjectDto) {
        return subjectsRepository.insert(new Subject(subjectDto.getInputName()));
    }

    @PostMapping("/subjects")
    public void updateSubject(@RequestBody SubjectDto subjectDto) {
        subjectsRepository.update(new Subject(subjectDto.getInputId(), subjectDto.getInputName()));
    }

    @DeleteMapping("/subjects")
    public int deleteSubject(@RequestBody SubjectDto subjectDto) {
        return subjectsRepository.delete(subjectDto.getInputId());
    }
}