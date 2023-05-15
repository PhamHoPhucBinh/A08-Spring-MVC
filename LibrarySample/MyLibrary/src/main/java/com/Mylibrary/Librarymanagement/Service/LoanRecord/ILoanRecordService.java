package com.Mylibrary.Librarymanagement.Service.LoanRecord;

import com.Mylibrary.Librarymanagement.Bean.LoanRecord;

import java.util.Optional;

public interface ILoanRecordService {
    Iterable<LoanRecord> findAll();

   <Optional> java.util.Optional<LoanRecord> findById(Integer loanId);

    Optional<LoanRecord> findByBookId(Integer bookId);

    void save(LoanRecord loanRecord);

    void remove(Integer loanId);
}
