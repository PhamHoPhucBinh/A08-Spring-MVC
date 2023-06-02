package com.myshop3pagesort.repository;

import com.myshop3pagesort.bean.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    Page<Enrollment> findByEnrollmentDate(Pageable pageable, Date date);
}
