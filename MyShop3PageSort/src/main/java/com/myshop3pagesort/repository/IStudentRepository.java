package com.myshop3pagesort.repository;

import com.myshop3pagesort.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findByStudentNameLike(Pageable pageable, String name);
}
