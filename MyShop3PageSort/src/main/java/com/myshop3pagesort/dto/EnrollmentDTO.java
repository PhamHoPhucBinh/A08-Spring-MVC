package com.myshop3pagesort.dto;

import java.util.Date;

public class EnrollmentDTO {
    private Integer studentId;
    private Integer enrollmentId;
    private Integer courseId;
    private Date enrollmentDate;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Integer studentId, Integer enrollmentId, Integer courseId, Date enrollmentDate) {
        this.studentId = studentId;
        this.enrollmentId = enrollmentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
