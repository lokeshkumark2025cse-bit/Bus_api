package com.example.busspass.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busspass.model.ApplicationStatus;
import com.example.busspass.model.PassApplication;

public interface Passapplicationrepo extends JpaRepository<PassApplication,Long> {
    boolean existsByStudent_StdidAndStatus(Long stdid, ApplicationStatus status);
    List<PassApplication> findByStudent_Stdid(Long stdid);

    List<PassApplication> findByValidUntilBetween(LocalDate start, LocalDate end);
    List<PassApplication> findByStatus(ApplicationStatus status);
}
