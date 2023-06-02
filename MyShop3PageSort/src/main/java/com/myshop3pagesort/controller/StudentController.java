package com.myshop3pagesort.controller;

import com.myshop3pagesort.bean.Student;
import com.myshop3pagesort.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping(value = "/show")
    public ModelAndView displayPageStudent(@PageableDefault(value = 3) Pageable pageable) {
        Page<Student> students = studentService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/student/show");
        modelAndView.addObject("students", students);
        if (students.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có học sinh nào cả.");
        }
        return modelAndView;
    }

    @GetMapping(value = "/search/{searchValue}")
    public ModelAndView showListSearch(@PageableDefault(value = 5) Pageable pageable, @PathVariable("searchValue") String name) {
        Page<Student> students = studentService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("view/student/resultSearchStudent");
        modelAndView.addObject("students", students);
        if (students.getContent().size() == 0) {
            modelAndView.addObject("message", "Không tìm thấy học sinh nào .");
        }
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String displayPageCreate(Model model) {
        model.addAttribute("student", new Student());
        return "view/student/create-student";
    }

    @PostMapping(value = "/create")
    public String saveCustomer(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/customer/create-student";
        } else {
            redirectAttributes.addFlashAttribute("message", "Create student: " + student.getStudentName() + " success.");
            studentService.save(student);
            return "redirect:view/student/show";
        }
    }


}
