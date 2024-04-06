
package com.franless.dao;

import java.util.List;

import com.franless.models.Student;

/**
 * IStudentDAO
 */
public interface IStudentDAO {
    List<Student> findAll();

    Student findBydId(int id);

    int save(Student student);

    int delete(int id);
}