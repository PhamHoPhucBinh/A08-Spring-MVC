package com.Mylibrary.Librarymanagement.Service.Book;

import com.Mylibrary.Librarymanagement.Bean.Book;
import com.Mylibrary.Librarymanagement.Repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
