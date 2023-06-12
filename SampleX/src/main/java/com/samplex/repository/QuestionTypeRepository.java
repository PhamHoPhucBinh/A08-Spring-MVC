package com.samplex.repository;

import com.samplex.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionTypeRepository extends PagingAndSortingRepository<QuestionType,Integer> {
    Page<QuestionType> findByTypeNameLike(Pageable pageable,String name);
}
