package com.myshop3pagesort.service.Course;

import com.myshop3pagesort.bean.Course;
import com.myshop3pagesort.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<Course> showAll(Pageable pageable);

    Page<Course> findByName(Pageable pageable, String name);

    Iterable<Course> findAll();

    Course findById(Integer id);

    void save(Course course);

    void delete(Course course);
}
