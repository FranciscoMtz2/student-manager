package com.franless.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franless.dao.IStudentDAO;
import com.franless.models.Student;

@Service
public class StudentService implements IService<Student> {
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        List<Student> students = studentDAO.findAll();
        // Implement business logic
        return students;
    }

    @Override
    public Student find(int id) {
        Student student = studentDAO.findBydId(id);
        // Implement business logic
        return student;
    }

    @Override
    public int create(Student student) {
        int id = studentDAO.save(student);
        // Implement business logic
        return id;
    }

    @Override
    public int update(Student student) {
        int rowAffected = studentDAO.save(student);
        // Implement business logic
        return rowAffected;
    }

    @Override
    public int destroy(int id) {
        int rowAffected = studentDAO.delete(id);
        // Implement business logic
        return rowAffected;
    }

}
