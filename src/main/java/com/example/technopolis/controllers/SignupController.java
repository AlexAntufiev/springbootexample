package com.example.technopolis.controllers;

import com.example.technopolis.model.SignupForm;
import com.example.technopolis.model.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: add doc
 *
 * @author Aleksey Antufev
 * @version 1.2.0
 * @since 1.2.0 19.05.2018
 */
//@RestController
//@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private SignupValidator signupValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String signup(ModelMap model) {
        SignupForm signupForm = new SignupForm();
        model.put("signupForm", signupForm);
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignup(SignupForm signupForm, BindingResult result) {
        signupValidator.validate(signupForm, result);
        if (result.hasErrors()) {
            return "signup";
        }
        return "signup-success";
    }
}