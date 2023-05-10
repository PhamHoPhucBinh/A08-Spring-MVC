package com.Mylibrary.Librarymanagement.Service.Student;

import com.Mylibrary.Librarymanagement.Bean.Book;
import com.Mylibrary.Librarymanagement.Bean.Student;

import java.util.Optional;

public interface IStudentService {
    Iterable<Student> findAll();

    Optional<Student> findById(Integer studentId);

    void save(Student student);

    void remove(Integer studentId);
}
