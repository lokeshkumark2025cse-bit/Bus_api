package com.example.busspass.service;

import com.example.busspass.model.Student;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentbyId(Long id);
}