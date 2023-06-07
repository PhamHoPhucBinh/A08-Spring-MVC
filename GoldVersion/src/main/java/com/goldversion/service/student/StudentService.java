package com.goldversion.service.student;

import com.goldversion.bean.Score;
import com.goldversion.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentService {
    Page<Student> showAll(Pageable pageable);

    Page<Student> findByName(Pageable pageable, String name);

    Iterable<Student> findAll();

    Optional<Student> findById(Integer id);

    void save(Student student);

    void delete(Student student);
}
