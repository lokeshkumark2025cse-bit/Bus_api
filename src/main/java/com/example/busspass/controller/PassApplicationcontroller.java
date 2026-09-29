package com.example.busspass.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busspass.model.ApplicationStatus;
import com.example.busspass.model.PassApplication;
import com.example.busspass.service.PassApplicationService;

@RestController
@RequestMapping("/applications")          //common URL for this page
public class PassApplicationcontroller {

    private PassApplicationService passApplicationService;                 //service imp

    public PassApplicationcontroller(PassApplicationService passApplicationService) {
        this.passApplicationService = passApplicationService;
    }

    @PostMapping                       //submiting the appilication
    public PassApplication submitApplication(@Valid @RequestBody PassApplication application) {
        return passApplicationService.submitApplication(application);
    }

    @GetMapping("/{applicationid}")           //finding the appilcation by id
    public PassApplication getApplicationById(@PathVariable Long applicationid) {
        return passApplicationService.getApplicationById(applicationid);
    }

    @GetMapping("/student/{stdid}")
    public List<PassApplication> getApplicationsByStudent(@PathVariable Long stdid) {
        return passApplicationService.getApplicationsByStudent(stdid);
    }

    @PutMapping("/{applicationid}/status")
    public PassApplication updateApplicationStatus(
            @PathVariable Long applicationid,
            @RequestBody StatusRequest request) {

        return passApplicationService.updateApplicationStatus(
                applicationid, request.status, request.remark);
    }

    @GetMapping("/expiring")
    public List<PassApplication> getApplicationsExpiringInNext30Days() {
        return passApplicationService.getApplicationsExpiringInNext30Days();
    }

    @GetMapping("/status/{status}")
public List<PassApplication> getApplicationsByStatus(
        @PathVariable ApplicationStatus status) {

    return passApplicationService.getApplicationsByStatus(status);
}

    public static class StatusRequest {
        public ApplicationStatus status;
        public String remark;
    }
}