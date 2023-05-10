package com.Mylibrary.Librarymanagement.Repository;

import com.Mylibrary.Librarymanagement.Bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
