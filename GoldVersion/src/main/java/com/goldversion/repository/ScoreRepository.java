package com.goldversion.repository;


import com.goldversion.bean.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends PagingAndSortingRepository<Score, Integer> {
    Page<Score> searchScoreByStudent_StudentNameOrSubject_SubjectName (String searchContent, String searchContent2,Pageable pageable);

}
