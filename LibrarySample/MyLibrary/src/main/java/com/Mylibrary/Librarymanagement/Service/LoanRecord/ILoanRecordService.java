package com.Mylibrary.Librarymanagement.Service.LoanRecord;

import com.Mylibrary.Librarymanagement.Bean.LoanRecord;

public interface ILoanRecordService {
    Iterable<LoanRecord> findAll();

   <Optional> java.util.Optional<LoanRecord> findById(Integer loanId);

    void save(LoanRecord loanRecord);

    void remove(Integer loanId);
}
