package com.myshop3pagesort.controller;

import com.myshop3pagesort.bean.Course;
import com.myshop3pagesort.bean.Enrollment;
import com.myshop3pagesort.bean.Student;

import com.myshop3pagesort.service.Course.CourseService;
import com.myshop3pagesort.service.Enrollment.EnrollmentService;
import com.myshop3pagesort.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/show")
    public ModelAndView displayPageEnrollment(@PageableDefault(value = 3, sort = "enrollmentId", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Enrollment> enrollments = enrollmentService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/enrollment/show");
        modelAndView.addObject("enrollments", enrollments);
        if (enrollments.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có lớp nào cả.");
        }
        return modelAndView;
    }


    //    @GetMapping("/create-enrollment")
//    public ModelAndView showCreateForm() {
//        Iterable<Student> students = studentService.findAll();
//        Iterable<Course> courses = courseService.findAll();
//        ModelAndView modelAndView = new ModelAndView("view/enrollment/create");
//
//        modelAndView.addObject("courses", courses);
//        modelAndView.addObject("students", students);
//        modelAndView.addObject("enrollment", new Enrollment());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-enrollment")
//    public ModelAndView saveEnrollment(@Valid @ModelAttribute("enrollment") Enrollment enrollment  , BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            ModelAndView modelAndView = new ModelAndView("view/enrollment/create");
//            modelAndView.addObject("courses", courseService.findAll());
//            modelAndView.addObject("students", studentService.findAll());
//            modelAndView.addObject("message", "k tim thay thong tin");
//            return modelAndView;
//        } else {
//            enrollmentService.save(enrollment);
//            ModelAndView modelAndView = new ModelAndView("view/enrollment/create");
//            modelAndView.addObject("enrollment", new Enrollment());
//            modelAndView.addObject("message", "Enrollment created successfully.");
//            return modelAndView;
//        }
//    }
    @GetMapping("/create-enrollment")
    public ModelAndView showCreateForm() {
        Iterable<Student> students = studentService.findAll();
        Iterable<Course> courses = courseService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/enrollment/create");
        modelAndView.addObject("courses", courses);
        modelAndView.addObject("students", students);
        modelAndView.addObject("enrollment", new Enrollment());
        return modelAndView;
    }

    @PostMapping("/create-student")
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveEnrollment(@Valid @ModelAttribute("enrollment") Enrollment enrollment  , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("view/enrollment/create");
            modelAndView.addObject("courses", courseService.findAll());
            modelAndView.addObject("students", studentService.findAll());
            modelAndView.addObject("message", "dữ liệu không hợp lệ");
            return modelAndView;
        } else {
            enrollmentService.save(enrollment);
            ModelAndView modelAndView = new ModelAndView("view/enrollment/create");
            modelAndView.addObject("courses", courseService.findAll());
            modelAndView.addObject("students", studentService.findAll());
            modelAndView.addObject("enrollment", new Enrollment());
            modelAndView.addObject("message", "Create student: " + enrollment.getEnrollmentId() + " success.");
            return modelAndView;
        }
    }
}
