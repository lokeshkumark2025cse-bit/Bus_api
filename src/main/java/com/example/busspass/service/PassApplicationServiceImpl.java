package com.example.busspass.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.busspass.exception.BusinessException;
import com.example.busspass.exception.ResourceNotFoundException;
import com.example.busspass.model.ApplicationStatus;
import com.example.busspass.model.PassApplication;
import com.example.busspass.repo.Passapplicationrepo;

@Service
public class PassApplicationServiceImpl implements PassApplicationService {

    private Passapplicationrepo passApplicationrepo;

    public PassApplicationServiceImpl(Passapplicationrepo passApplicationrepo) {
        this.passApplicationrepo = passApplicationrepo;
    }

    @Override
    public PassApplication submitApplication(PassApplication application) {
        return passApplicationrepo.save(application);
    }

    @Override
    public PassApplication getApplicationById(Long id) {
        return passApplicationrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    @Override
    public List<PassApplication> getApplicationsByStudent(Long studentId) {
        return passApplicationrepo.findAll();
    }

    @Override
    public PassApplication updateApplicationStatus(Long id, ApplicationStatus status, String remark) {

        PassApplication application = passApplicationrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Application not found"));

        if (status == ApplicationStatus.REJECTED && (remark == null || remark.isBlank())) {
            throw new BusinessException("Rejection reason is required");
        }

        application.setStatus(status);
        application.setRemark(remark);

        return passApplicationrepo.save(application);
    }

    @Override
    public List<PassApplication> getApplicationsExpiringInNext30Days() {
        return passApplicationrepo.findAll();
    }
}