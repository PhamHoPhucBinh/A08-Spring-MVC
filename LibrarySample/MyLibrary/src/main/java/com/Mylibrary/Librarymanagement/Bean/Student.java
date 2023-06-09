package com.Mylibrary.Librarymanagement.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", nullable = false)
    private Integer studentId;

    @Column(name = "STUDENT_CODE", nullable = false)
    private String studentCode;

    @Column(name = "FULL_NAME", nullable = false)
    @NotEmpty
    @Size(min = 2, max = 30)
    private String fullName;

    @Column(name = "EMAIL", unique = true)
    @NotEmpty
    @Size(min = 2, max = 30)
    private String email;

    @Column(name = "PHONE_NUMBER", unique = true)
    @NotEmpty
    @Size(min = 2, max = 30)
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b")
    private String phoneNumber;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    public Student(String studentCode, String fullName, String email, String phoneNumber, boolean enabled) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
    }

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
