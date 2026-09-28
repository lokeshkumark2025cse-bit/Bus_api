package com.example.busspass.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity 
public class PassApplication {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationid;
  
     @ManyToOne          //from class side we need to see-many application belong to one student
    private Student student;
    @ManyToOne                 //many application have one bus route
    private Busroute busRoute;
     private String boardingPoint;
    private String photoReference;
    private LocalDate applicationDate;
    private ApplicationStatus status;
    private String remark;
    private String passNumber;
    private LocalDate validFrom;
    private LocalDate validUntil;


    public PassApplication(Student student, Busroute busRoute,
                           String boardingPoint, String photoReference,
                           LocalDate applicationDate,
                           ApplicationStatus status, String remark,
                           String passNumber, LocalDate validFrom,
                           LocalDate validUntil) {
        this.student = student;
        this.busRoute = busRoute;
        this.boardingPoint = boardingPoint;
        this.photoReference = photoReference;
        this.applicationDate = applicationDate;
        this.status = status;
        this.remark = remark;
        this.passNumber = passNumber;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    public Long getApplicationid() {
        return applicationid;
    }
    public void setApplicationid(Long applicationid) {
        this.applicationid = applicationid;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Busroute getBusRoute() {
        return busRoute;
    }
    public void setBusRoute(Busroute busRoute) {
        this.busRoute = busRoute;
    }
    public String getBoardingPoint() {
        return boardingPoint;
    }
    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }
    public String getPhotoReference() {
        return photoReference;
    }
    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }
    public LocalDate getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
    public ApplicationStatus getStatus() {
        return status;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getPassNumber() {
        return passNumber;
    }
    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }
    public LocalDate getValidFrom() {
        return validFrom;
    }
    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }
    public LocalDate getValidUntil() {
        return validUntil;
    }
    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}
