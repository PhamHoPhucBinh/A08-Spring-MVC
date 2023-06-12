package com.samplex.repository;

import com.samplex.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionRepository extends PagingAndSortingRepository<Question,Integer> {
    Page<Question> findByTitleLike(Pageable pageable, String name);
    Page<Question> findByQuestionType_TypeNameLike(Pageable pageable, String name);
}
