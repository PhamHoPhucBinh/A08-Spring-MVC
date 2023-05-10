package com.Mylibrary.Librarymanagement.Repository;

import com.Mylibrary.Librarymanagement.Bean.Book;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {
//    @Query(value = "SELECT b from Book as b WHERE b.title like ?1")
//    Page<Book> search(String valueSearch, SpringDataWebProperties.Pageable pageable);
}
