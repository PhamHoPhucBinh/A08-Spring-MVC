package com.Mylibrary.Librarymanagement.dto;


import java.util.Date;

public class LoanRecordDTO {
    java.lang.Integer studentId;
    String returnDate;

    Integer book;

    public LoanRecordDTO() {
    }

    public LoanRecordDTO(java.lang.Integer studentId, String returnDate) {
        this.studentId = studentId;
        this.returnDate = returnDate;
    }

    public LoanRecordDTO(java.lang.Integer studentId, String returnDate, Integer book) {
        this.studentId = studentId;
        this.returnDate = returnDate;
        this.book = book;
    }

    public java.lang.Integer getStudentId() {
        return studentId;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public void setStudentId(java.lang.Integer studentId) {
        this.studentId = studentId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
