package com.example.technopolis.services;

import com.example.technopolis.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aleksey Antufev
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {}