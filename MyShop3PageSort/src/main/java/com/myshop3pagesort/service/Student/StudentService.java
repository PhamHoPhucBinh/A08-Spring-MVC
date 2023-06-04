package com.myshop3pagesort.service.Student;

import com.myshop3pagesort.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> showAll(Pageable pageable);

    Page<Student> findByName(String name,Pageable pageable );

    Iterable<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    void delete(Student student);
}
