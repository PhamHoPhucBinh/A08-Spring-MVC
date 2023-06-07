package com.myshop3pagesort.service.Enrollment;

import com.myshop3pagesort.bean.Enrollment;
import com.myshop3pagesort.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface EnrollmentService {
    Page<Enrollment> showAll(Pageable pageable);


    Page<Enrollment> findByDate(Pageable pageable, Date date);

    Iterable<Enrollment> findAll();

    Enrollment findById(Integer id);

    void save(Enrollment enrollment);

    void deleteById(Integer id);

}
