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

    @GetMapping("/score")
    public ModelAndView scorePage() {
        repository.updateScore();
        Map<String, String> model = new HashMap<>();
        model.put("score", String.valueOf(repository.getScore().getScore()));
        return new ModelAndView("index", model);
    }

    @GetMapping("/")
    public ModelAndView mainPage() {
        Map<String, String> model = new HashMap<>();
//        model.put("score", String.valueOf(repository.getScore().getScore()));
        return new ModelAndView("index1", model);
    }

    @GetMapping("/logon")
    public ModelAndView logon() {
        Map<String, String> model = new HashMap<>();
        //        model.put("score", String.valueOf(repository.getScore().getScore()));
        return new ModelAndView("index1", model);
    }
}
