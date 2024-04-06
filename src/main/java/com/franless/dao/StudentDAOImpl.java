package com.franless.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.franless.mappers.StudentRowMapper;
import com.franless.models.Student;

public class StudentDAOImpl implements IStudentDAO {

    @Autowired
    private JdbcTemplate dbTemplate;

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        List<Student> students = dbTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student findBydId(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = dbTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public int save(Student student) {
        String sql;
        List<Object> args = new ArrayList<>();
        args.add(student.getName());
        args.add(student.getMobile());
        args.add(student.getCountry());
        if (student.getId() == null) {
            sql = "INSERT INTO students values(null,?,?,?)";
        } else {
            sql = "UPDATE students SET name = ?, mobile = ?, country = ? WHERE id = ?";
            args.add(student.getId());
        }
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        dbTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                for (int i = 0; i <= args.size() - 1; i++) {
                    ps.setObject(1 + i, args.get(i));
                    System.out.println(ps.toString());
                }
                return ps;
            }
        }, keyHolder);
        if (keyHolder.getKey() == null) {
            return student.getId();
        }
        return keyHolder.getKey().intValue();
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        int rowAffected = dbTemplate.update(sql, id);
        return rowAffected;
    }

}
