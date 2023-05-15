package com.Mylibrary.Librarymanagement.Repository;

import com.Mylibrary.Librarymanagement.Bean.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILoanRecordRepository extends JpaRepository<LoanRecord,Integer> {
Optional<LoanRecord> findLoanRecordByBook_BookId(Integer bookId);
}
