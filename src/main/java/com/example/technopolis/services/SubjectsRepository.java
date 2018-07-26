//package com.example.technopolis.services;
//
//import com.example.technopolis.model.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class SubjectsRepository {
//
//    @Autowired
//    private JdbcTemplate db;
//
//    public long insert(Subject subject) {
//        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(subject);
//        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(db)
//            .withTableName("Subject")
//            .usingColumns("name")
//            .usingGeneratedKeyColumns("id");
//        Number newId = simpleJdbcInsert.executeAndReturnKey(parameterSource);
//        return newId.longValue();
//    }
//
//    public List<Subject> get() {
//        return db.query(
//            "select * from subject",
//            (rs, rowNum) -> new Subject(rs.getLong("id"), rs.getString("name"))
//        );
//    }
//
//    private static class SubjectRowMapper implements RowMapper<Subject> {
//        @Override
//        public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new Subject(rs.getLong("id"), rs.getString("name"));
//        }
//    }
//
//    public Subject get(long id) {
//        return db.queryForObject(
//            "select * from subject where id=?",
//            new BeanPropertyRowMapper<>(Subject.class),
//            id
//        );
//    }
//
//    public int update(Subject subject) {
//        return db.update("update subject set name =? where id=?", subject.getName(), subject.getId());
//    }
//
//    public int delete(Long id) {
//        return db.update("delete from subject where id=?", id);
//    }
//}