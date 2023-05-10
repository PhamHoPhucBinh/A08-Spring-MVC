package com.Mylibrary.Librarymanagement.Service.Student;

import com.Mylibrary.Librarymanagement.Bean.Student;
import com.Mylibrary.Librarymanagement.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
