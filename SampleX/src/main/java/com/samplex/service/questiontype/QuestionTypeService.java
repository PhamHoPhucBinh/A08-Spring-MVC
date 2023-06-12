package com.samplex.service.questiontype;

import com.samplex.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface QuestionTypeService {
    Page<QuestionType> showAll(Pageable pageable);

    Page<QuestionType> findByName(Pageable pageable, String name);

    Iterable<QuestionType> findAll();

    Optional<QuestionType> findById(Integer id);

    void save(QuestionType questionType);

    void deleteById(Integer id);
}
