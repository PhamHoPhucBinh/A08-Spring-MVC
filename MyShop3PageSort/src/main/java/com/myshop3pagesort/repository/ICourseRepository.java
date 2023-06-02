package com.myshop3pagesort.repository;

import com.myshop3pagesort.bean.Course;
import com.myshop3pagesort.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
    Page<Course> findByCourseNameLike(Pageable pageable, String name);
}
