package com.example.technopolis.controllers;

import com.example.technopolis.services.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    ScoreRepository repository;

    @GetMapping("/")
    public ModelAndView mainPage(){
        repository.updateScore();
        Map<String, String> model = new HashMap<>();
        model.put("score", String.valueOf(repository.getScore().getScore()));
        return new ModelAndView("index", model);
    }
}
