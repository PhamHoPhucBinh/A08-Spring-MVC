package com.goldversion.repository;

import com.goldversion.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
    Page<Student> findByStudentNameLike(Pageable pageable, String name);
}
