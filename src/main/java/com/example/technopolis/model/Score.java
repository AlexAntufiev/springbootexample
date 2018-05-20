package com.example.technopolis.model;

public class Score {

    private int id;
    private int score;

    public Score() {
        super();
    }

    public Score(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
