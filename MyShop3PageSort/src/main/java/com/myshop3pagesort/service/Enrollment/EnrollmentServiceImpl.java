package com.myshop3pagesort.service.Enrollment;

import com.myshop3pagesort.bean.Enrollment;
import com.myshop3pagesort.repository.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private IEnrollmentRepository enrollmentRepository;

    @Override
    public Page<Enrollment> showAll(Pageable pageable) {
        return enrollmentRepository.findAll(pageable);
    }

    @Override
    public Page<Enrollment> findByDate(Pageable pageable, Date date) {
        return enrollmentRepository.findByEnrollmentDate(pageable, date);
    }

    @Override
    public Iterable<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment findById(Integer id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(Integer id) {
        enrollmentRepository.deleteById(id);
    }
}
