package com.Mylibrary.Librarymanagement.Controller;


import com.Mylibrary.Librarymanagement.Bean.Student;
import com.Mylibrary.Librarymanagement.Service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Validated
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
    public ModelAndView saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("view/student/create");
        }
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("view/student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "create successfully");
        return new ModelAndView("redirect:/students");
    }

    @GetMapping("/students")
    public ModelAndView listStudents() {
        Iterable<Student> students = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/edit-student/{studentId}")
    public ModelAndView showEditForm(@PathVariable Integer studentId) {
        Optional<Student> student = studentService.findById(studentId);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/student/edit");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return new ModelAndView("redirect:/students");
        }
    }

    @PostMapping("/edit-student")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("view/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-student/{studentId}")
    public ModelAndView showDeleteForm(@PathVariable Integer studentId) {
        Optional<Student> student = studentService.findById(studentId);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/student/delete");
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
