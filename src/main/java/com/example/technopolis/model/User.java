package com.example.technopolis.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO: add doc
 *
 * @author Aleksey Antufev
 * @version 1.2.0
 * @since 1.2.0 21.05.2018
 */
@Data
@Table
@Entity
@NoArgsConstructor
public class User {

    @Id
    @Email
    @NotBlank
    String email;

    @Length(min = 10)
    @NotBlank
    String password;
}
