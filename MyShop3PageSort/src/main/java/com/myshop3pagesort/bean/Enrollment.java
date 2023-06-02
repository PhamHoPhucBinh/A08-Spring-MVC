package com.myshop3pagesort.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENROLLMENT_ID", nullable = false)
    private Integer enrollmentId;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course;

    private Date enrollmentDate;

}
