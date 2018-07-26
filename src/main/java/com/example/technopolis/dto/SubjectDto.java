package com.example.technopolis.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aleksey Antufev
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectDto {

    @NotNull
    private Long inputId;

    @NotNull
    @Min(1)
    private String inputName;
}
