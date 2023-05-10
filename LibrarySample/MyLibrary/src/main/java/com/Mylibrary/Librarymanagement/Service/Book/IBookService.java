package com.Mylibrary.Librarymanagement.Service.Book;

import com.Mylibrary.Librarymanagement.Bean.Book;

import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();

    Optional<Book> findById(Integer bookId);

    void save(Book Book);

    void remove(Integer bookId);
}
