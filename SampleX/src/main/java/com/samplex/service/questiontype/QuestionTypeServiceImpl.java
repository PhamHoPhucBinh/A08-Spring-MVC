package com.samplex.service.questiontype;

import com.samplex.model.QuestionType;
import com.samplex.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public Page<QuestionType> showAll(Pageable pageable) {
        return questionTypeRepository.findAll(pageable);
    }

    @Override
    public Page<QuestionType> findByName(Pageable pageable, String name) {
        return questionTypeRepository.findByTypeNameLike(pageable, name);
    }

    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(Integer id) {
        return questionTypeRepository.findById(id);
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void deleteById(Integer id) {
        questionTypeRepository.deleteById(id);
    }
}
