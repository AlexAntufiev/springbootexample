package com.example.technopolis.services;

import com.example.technopolis.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: add doc
 *
 * @author Aleksey Antufev
 * @version 1.2.0
 * @since 1.2.0 21.05.2018
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {}