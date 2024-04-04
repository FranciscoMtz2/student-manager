package com.franless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.franless.dao.IStudentDAO;
import com.franless.models.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("student/")
public class StudentController {
    @Autowired
    private IStudentDAO studentDAO;

    @ModelAttribute("student")
    public Student getStudentModelAttribute() {
        Student student = new Student();
        return student;
    }

    @GetMapping("create/")
    public String create(Model model) {
        return "students/create";
    }

}
