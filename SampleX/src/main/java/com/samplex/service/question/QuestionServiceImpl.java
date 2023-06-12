package com.samplex.service.question;

import com.samplex.model.Question;
import com.samplex.repository.QuestionRepository;
import com.samplex.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Page<Question> showAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findByName(Pageable pageable, String name) {
        return questionRepository.findByTitleLike(pageable, name);
    }

    @Override
    public Page<Question> findByType(Pageable pageable, String name) {
        return questionRepository.findByQuestionType_TypeNameLike(pageable,name);
    }

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteById(Integer id) {
        questionRepository.deleteById(id);
    }
}
