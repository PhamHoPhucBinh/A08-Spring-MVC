package com.goldversion.service.score;

import com.goldversion.bean.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ScoreService {
    Page<Score> showAll(Pageable pageable);

    Iterable<Score> findAll();

    Optional<Score>  findById(Integer id);

    void save(Score score);

    void deleteById(Integer id);

    Page<Score> searchScore(Pageable pageable,String searchContent);
}
