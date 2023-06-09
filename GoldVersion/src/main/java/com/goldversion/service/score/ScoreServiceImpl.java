package com.goldversion.service.score;

import com.goldversion.bean.Score;
import com.goldversion.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Page<Score> showAll(Pageable pageable) {
        return scoreRepository.findAll(pageable);
    }


    @Override
    public Iterable<Score> findAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Optional<Score> findById(Integer id) {
        return scoreRepository.findById(id);
    }


    @Override
    public void save(Score score) {
        scoreRepository.save(score);
    }

    @Override
    public void deleteById(Integer id) {
        scoreRepository.deleteById(id);
    }

    @Override
    public Page<Score> searchScore(Pageable pageable, String searchContent) {
        return scoreRepository.searchScoreByStudent_StudentNameOrSubject_SubjectName(searchContent,searchContent,pageable);
    }
}
