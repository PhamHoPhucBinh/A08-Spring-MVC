package com.Mylibrary.Librarymanagement.Repository;

import com.Mylibrary.Librarymanagement.Bean.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoanRecordRepository extends JpaRepository<LoanRecord,Integer> {

}
