package com.franless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.franless.models.Student;
import com.franless.services.IService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IService<Student> studentService;

    @ModelAttribute("student")
    public Student getStudentModelAttribute() {
        return new Student();
    }

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/index";
    }

    @GetMapping("/show/{id}")
    public String getShow(@PathVariable("id") int id, Model model) {
        Student student = studentService.find(id);
        model.addAttribute("student", student);
        return "students/show";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        return "students/create";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable("id") int id, Model model) {
        Student student = studentService.find(id);
        model.addAttribute("student", student);
        return "students/update";
    }

    @PostMapping("/create")
    public String postCreate(Student student) {
        int idCreated = studentService.create(student);
        return "redirect:/students/show/" + String.valueOf(idCreated);
    }

    @PutMapping("/update")
    public String putUpdate(Student student) {
        int idCreated = studentService.update(student);
        return "redirect:/students/show/" + String.valueOf(idCreated);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) {
        studentService.destroy(id);
        return "redirect:/students";
    }
}
