package com.samplex.service.question;

import com.samplex.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface QuestionService {
    Page<Question> showAll(Pageable pageable);

    Page<Question> findByName(Pageable pageable, String name);

    Page<Question> findByType(Pageable pageable,String name);

    Iterable<Question> findAll();

    Optional<Question> findById(Integer id);

    void save(Question question);

    void deleteById(Integer id);

}
