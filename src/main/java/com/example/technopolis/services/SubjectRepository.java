package com.example.technopolis.services;

import com.example.technopolis.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aleksey Antufev
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
