package com.example.demo.repository;

import com.example.demo.bean.Blog;
import com.example.demo.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    List<Blog> findByTitleLike(String searchValue);

    Iterable<Blog> findByCategory(Category category);

    @Query("SELECT b FROM Blog b ORDER BY b.date DESC")
    Page<Blog> findAllByOrOrderByDateDesc(Pageable pageable);

}
