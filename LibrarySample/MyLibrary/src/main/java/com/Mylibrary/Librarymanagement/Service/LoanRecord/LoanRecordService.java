package com.Mylibrary.Librarymanagement.Service.LoanRecord;

import com.Mylibrary.Librarymanagement.Bean.LoanRecord;
import com.Mylibrary.Librarymanagement.Repository.ILoanRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanRecordService implements ILoanRecordService {
    @Autowired
    private ILoanRecordRepository loanRecordRepository;

    @Override
    public Iterable<LoanRecord> findAll() {
        return loanRecordRepository.findAll();
    }


    @Override
    public Optional<LoanRecord> findById(Integer loanId) {
        return loanRecordRepository.findById(loanId);
    }

    @Override
    public Optional<LoanRecord> findByBookId(Integer bookId){
        return loanRecordRepository.findLoanRecordByBook_BookId(bookId);
    }


    @Override
    public void save(LoanRecord loanRecord) {
        loanRecordRepository.save(loanRecord);
    }

    @Override
    public void remove(Integer loanId) {
        loanRecordRepository.deleteById(loanId);
    }
}
