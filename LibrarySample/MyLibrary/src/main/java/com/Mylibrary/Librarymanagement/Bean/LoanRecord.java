package com.Mylibrary.Librarymanagement.Bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOAN_RECORD")
public class LoanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_ID", nullable = false)
    private Integer loanId;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    @Column(name = "LOAN_DATE", nullable = false)
    private Date loanDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;
}
