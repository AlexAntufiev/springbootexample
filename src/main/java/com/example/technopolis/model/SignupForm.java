package com.example.technopolis.model;

import lombok.Data;

/**
 * TODO: add doc
 *
 * @author Aleksey Antufev
 * @version 1.2.0
 * @since 1.2.0 19.05.2018
 */
@Data
public class SignupForm {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
