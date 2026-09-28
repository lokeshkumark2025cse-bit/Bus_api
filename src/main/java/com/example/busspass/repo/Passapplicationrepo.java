package com.example.busspass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busspass.model.PassApplication;

public interface Passapplicationrepo extends JpaRepository<PassApplication,Long> {

}
