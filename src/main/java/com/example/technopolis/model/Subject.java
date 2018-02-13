package com.example.technopolis.model;

import java.io.Serializable;

public class Subject implements Serializable {

    private final long id;
    private final String name;

    public Subject(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}