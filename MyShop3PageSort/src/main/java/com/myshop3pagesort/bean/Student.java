package com.myshop3pagesort.bean;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", nullable = false)
    private Integer studentId;
    @Column(name = "STUDENT_NAME", nullable = false)
    @NotEmpty
    private String studentName;

    private String email;

    public Student() {
    }

    public Student(Integer studentId, String studentName, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
