package com.goldversion.repository;

import com.goldversion.bean.Student;
import com.goldversion.bean.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer> {
    Page<Subject> findBySubjectNameLike(Pageable pageable, String name);
}
