package com.goldversion.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    @NotBlank(message = "Subject name cannot be blank")
    @Size(min = 5, message = "Subject name cannot be shorter than 5 characters")
    private String subjectName;
    private Integer credits;
    private String subjectClass;

    public Subject() {
    }

    public Subject(Integer subjectId, String subjectName, Integer credits, String subjectClass) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credits = credits;
        this.subjectClass = subjectClass;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getSubjectClass() {
        return subjectClass;
    }

    public void setSubjectClass(String subjectClass) {
        this.subjectClass = subjectClass;
    }
}
