package com.example.busspass.service;

import com.example.busspass.model.ApplicationStatus;
import com.example.busspass.model.PassApplication;

import java.util.List;

public interface PassApplicationService {

   PassApplication submitApplication(PassApplication application);
    PassApplication getApplicationById(Long id);
    List<PassApplication> getApplicationsByStudent(Long studentId);
    PassApplication updateApplicationStatus(Long id, ApplicationStatus status, String remark);
    List<PassApplication> getApplicationsExpiringInNext30Days();
}