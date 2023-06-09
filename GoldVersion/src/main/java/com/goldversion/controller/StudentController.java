package com.goldversion.controller;

import com.goldversion.bean.Student;
import com.goldversion.bean.Subject;
import com.goldversion.service.student.StudentService;
import com.goldversion.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // TODO: 24-May-23 list
    @GetMapping(value = "/show-student")
    public ModelAndView displayPageStudent(@PageableDefault(value = 3, sort = "studentName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Student> students = studentService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/student/show-student");
        modelAndView.addObject("students", students);
        if (students.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có môn học nào cả.");
        }
        return modelAndView;
    }

    // TODO: 24-May-23 : create
    @GetMapping("/create-student")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("view/student/create-student");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ModelAndView("view/student/create-student");
        }
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("view/student/create-student");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "create successfully");
        return new ModelAndView("redirect:/student/show-student");
    }

    // TODO: 24-May-23 : edit
    @GetMapping(value = "/edit-student/{studentId}")
    public ModelAndView showPageUpdate(@PathVariable Integer studentId) {
        Optional<Student> student = studentService.findById(studentId);
        return new ModelAndView("view/student/edit-student", "student", student);
    }

    @PostMapping(value = "/edit-student")
    public String updateStudent(@Validated @ModelAttribute Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/student/edit-student";
        } else {
            redirectAttributes.addFlashAttribute("message", "Update student: " + student.getStudentName() + " success.");
            studentService.save(student);
            return "redirect:/student/show-student";
        }
    }

    // TODO: 24-May-23 Delete



    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        studentService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete Succesfully!");
        return "redirect:/student/show-student";
    }

    @GetMapping(value = "/search-student")
    public ModelAndView showListSearch(@PageableDefault(value = 3, sort = "studentName")
                                           Pageable pageable, @RequestParam(value = "search-student", required = false) String name) {
        Page<Student> students = studentService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("view/student/search-student");
        modelAndView.addObject("students", students);
        if (students.getContent().size() == 0) {
            modelAndView.addObject("message", " There is no found result !");
        }
        return modelAndView;
    }
}
