package com.goldversion.service.subject;

import com.goldversion.bean.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SubjectService {
    Page<Subject> showAll(Pageable pageable);

    Page<Subject> findByName(Pageable pageable, String name);

    Iterable<Subject> findAll();

    Optional<Subject> findById(Integer id);

    void save(Subject subject);

    void deleteById(Integer id);
}
