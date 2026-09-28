package com.example.busspass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busspass.model.Student;

public interface Studentrepo extends JpaRepository<Student,Long> {

}
