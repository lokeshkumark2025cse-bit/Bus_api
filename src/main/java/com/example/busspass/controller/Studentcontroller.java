package com.example.busspass.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busspass.model.Student;
import com.example.busspass.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class Studentcontroller {

    private final StudentService studentService;

    public Studentcontroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{stdid}")
    public Student getStudentById(@PathVariable Long stdid) {
        return studentService.getStudentbyId(stdid);
    }
}