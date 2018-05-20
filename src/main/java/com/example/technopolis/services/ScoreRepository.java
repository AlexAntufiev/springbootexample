package com.example.technopolis.services;

import com.example.technopolis.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Score getScore() {
        return jdbcTemplate.queryForObject("select * from score", new BeanPropertyRowMapper<>(Score.class));
    }

    public void updateScore() {
        int curScore = getScore().getScore();
        curScore++;
        jdbcTemplate.execute("update score set score =" + curScore + "where id = 1");
    }
}
