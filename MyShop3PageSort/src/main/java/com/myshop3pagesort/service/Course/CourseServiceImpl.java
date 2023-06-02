package com.myshop3pagesort.service.Course;

import com.myshop3pagesort.bean.Course;
import com.myshop3pagesort.bean.Student;
import com.myshop3pagesort.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Page<Course> showAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Page<Course> findByName(Pageable pageable, String name) {
        return courseRepository.findByCourseNameLike(pageable, name);
    }

    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }
}
