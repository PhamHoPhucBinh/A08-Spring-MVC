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

    public LoanRecord(Book book, Student student, Date loanDate, Date returnDate) {
        this.book = book;
        this.student = student;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public LoanRecord() {

    }


    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
