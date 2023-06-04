package com.myshop3pagesort.controller;

import com.myshop3pagesort.bean.Student;
import com.myshop3pagesort.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    public StudentService studentService;



    @GetMapping(value = "/show")
    public ModelAndView displayPageStudent(@PageableDefault(value = 3, sort = "studentName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Student> students = studentService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/student/show");
        modelAndView.addObject("students", students);
        if (students.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có học sinh nào cả.");
        }
        return modelAndView;
    }


    @GetMapping(value = "/search/{searchValue}")
    public ModelAndView showListSearch(@PageableDefault(value = 5) Pageable
                                               pageable, @PathVariable("searchValue") String name) {
        Page<Student> students = studentService.findByName("%" + name + "%", pageable);
        ModelAndView modelAndView = new ModelAndView("view/student/resultSearchStudent");
        modelAndView.addObject("students", students);
        if (students.getContent().size() == 0) {
            modelAndView.addObject("message", "Không tìm thấy học sinh nào .");
        }
        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("view/student/create-student");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("view/student/create-student");
            modelAndView.addObject("message", "dữ liệu không hợp lệ");
            return modelAndView;
        } else {
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView("view/student/create-student");
            modelAndView.addObject("student", new Student());
            modelAndView.addObject("message", "Create student: " + student.getStudentName() + " success.");
            return modelAndView;
        }
    }


}
