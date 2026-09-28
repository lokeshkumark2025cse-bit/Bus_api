package com.example.busspass.service;

import com.example.busspass.model.Student;
import com.example.busspass.repo.Studentrepo;
import org.springframework.stereotype.Service;

@Service
public class StudentserviceImpl implements StudentService {

    private final Studentrepo studentrepo;

    public StudentserviceImpl(Studentrepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentrepo.save(student);
    }

    @Override
    public Student getStudentbyId(Long id) {
        return studentrepo.findById(id).orElse(null);
    }
}