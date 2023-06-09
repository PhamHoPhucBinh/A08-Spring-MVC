package com.goldversion.bean;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @NotBlank(message = "Student name cannot be blank")
    @Size(min = 5, message = "Student name cannot be shorter than 5 characters")
    private String studentName;
    private String gender;
    @NotNull(message = "Birthday cannot be null")
    @Past(message = "Birthday cannot be in the future")
    private Date birthday;
    private String grade;

    public Student() {
    }

    public Student(Integer studentId, String studentName, String gender, Date birthday, String grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.grade = grade;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
