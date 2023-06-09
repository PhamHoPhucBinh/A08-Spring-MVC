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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Map;

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
        Iterable<Student> students = studentService.findAll();
        Iterable<Course> courses = courseService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/enrollment/show");
        modelAndView.addObject("courses", courses);
        modelAndView.addObject("students", students);
        modelAndView.addObject("enrollments", enrollments);
        if (enrollments.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có lớp nào cả.");
        }
        return modelAndView;
    }

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

    @PostMapping("/create-enrollment")
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

    @GetMapping("/delete-enrollment/{id}")
    public String deleteSubject(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        enrollmentService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/enrollment/show";
    }

    @PostMapping("/edit-enrollment")
    public ResponseEntity<Void> updateEnrollment(String maps) {
        System.out.println(maps);

//        Enrollment enrollment = enrollmentService.findById(enrollmentId);
//        enrollment.setEnrollmentDate(enrollmentDate);
//
//        enrollmentService.save(enrollment);
        return ResponseEntity.ok().build();
    }

}
