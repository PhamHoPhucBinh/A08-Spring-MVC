package com.Mylibrary.Librarymanagement.Controller;


import com.Mylibrary.Librarymanagement.Bean.Student;
import com.Mylibrary.Librarymanagement.Service.Book.IBookService;
import com.Mylibrary.Librarymanagement.Service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/Create-Student")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("view/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/Create-Student")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("view/student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "create successfully");
        return modelAndView;
    }

    @GetMapping("/students")
    public ModelAndView listStudents() {
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("student", students);
        return modelAndView;
    }

    @GetMapping("/edit-student/{studentId}")
    public ModelAndView showEditForm(@PathVariable Integer studentId) {
        Optional<Student> student = studentService.findById(studentId);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-student")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-student/{studentId}")
    public ModelAndView showDeleteForm(@PathVariable Integer studentId) {
        Optional<Student> student = studentService.findById(studentId);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/delete");
            modelAndView.addObject("student", student.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@ModelAttribute("student") Student student) {
        studentService.remove(student.getStudentId());
        return "redirect:students";
    }
}