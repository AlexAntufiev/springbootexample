package com.example.technopolis.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: add doc
 *
 * @author Aleksey Antufev
 * @version 1.2.0
 * @since 1.2.0 19.05.2018
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectDto {

    Long inputId;
    String inputName;
}
