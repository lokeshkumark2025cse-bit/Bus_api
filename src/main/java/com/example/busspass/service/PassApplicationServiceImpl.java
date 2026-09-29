package com.example.busspass.service;

import java.time.LocalDate;
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

    Long studentId = application.getStudent().getStdid();

    boolean activePassExists =
            passApplicationrepo.existsByStudent_StdidAndStatus(
                    studentId, ApplicationStatus.ACTIVE);

    if (activePassExists) {
        throw new BusinessException("Student already has an active pass");
    }

    return passApplicationrepo.save(application);
}

    @Override
    public PassApplication getApplicationById(Long id) {
        return passApplicationrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    @Override
    public List<PassApplication> getApplicationsByStudent(Long studentId) {
        return passApplicationrepo.findByStudent_Stdid(studentId);
    }

   @Override
public PassApplication updateApplicationStatus(Long id, ApplicationStatus status, String remark) {

    PassApplication application = passApplicationrepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Application not found"));

    if (status == ApplicationStatus.REJECTED && (remark == null || remark.isBlank())) {
        throw new BusinessException("Rejection reason is required");
    }

    application.setStatus(status);
    application.setRemark(remark);

    if (status == ApplicationStatus.APPROVED) {
        application.setPassNumber("PASS-" + application.getApplicationid());
        application.setValidFrom(java.time.LocalDate.now());
        application.setValidUntil(java.time.LocalDate.now().plusDays(30));
        application.setStatus(ApplicationStatus.ACTIVE);
    }

    return passApplicationrepo.save(application);
}


   @Override
public List<PassApplication> getApplicationsExpiringInNext30Days() {
    LocalDate today = LocalDate.now();
    LocalDate next30Days = today.plusDays(30);

    return passApplicationrepo.findByValidUntilBetween(today, next30Days);
}

  @Override
public List<PassApplication> getApplicationsByStatus(ApplicationStatus status) {
    return passApplicationrepo.findByStatus(status);
}

}