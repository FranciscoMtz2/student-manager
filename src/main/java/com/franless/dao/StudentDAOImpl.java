package com.franless.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.franless.mappers.StudentRowMapper;
import com.franless.models.Student;

@Service
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
        String sql = "INSERT INTO students values(null,?,?,?)";
        int rowsUpdated = dbTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry());
        return rowsUpdated;
    }

}
