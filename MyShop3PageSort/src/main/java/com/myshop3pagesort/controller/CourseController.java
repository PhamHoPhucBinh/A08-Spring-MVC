package com.myshop3pagesort.controller;

import com.myshop3pagesort.bean.Course;
import com.myshop3pagesort.bean.Student;
import com.myshop3pagesort.service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    // TODO: 24-May-23 list
    @GetMapping(value = "/show")
    public ModelAndView displayPageCourse(@PageableDefault(value = 3, sort = "courseName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Course> courses = courseService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/course/show");
        modelAndView.addObject("courses", courses);
        if (courses.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có lớp nào cả.");
        }
        return modelAndView;
    }

    // TODO: 24-May-23 : create
    @GetMapping("/create-course")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("view/course/create");
        modelAndView.addObject("course", new Course());
        return modelAndView;
    }

    @PostMapping("/create-course")
    public ModelAndView saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        ModelAndView modelAndView = new ModelAndView("view/course/create");
        modelAndView.addObject("course", new Course());
        modelAndView.addObject("message", "create successfully");
        return new ModelAndView("redirect:/course/show");
    }

    // TODO: 24-May-23 : edit
    @GetMapping("/edit-course/{courseId}")
    public ModelAndView showEditForm(@PathVariable Integer courseId) {
        Optional<Course> course = Optional.ofNullable(courseService.findById(courseId));
        if (course.isPresent()) {
            Iterable<Course> courses = courseService.findAll();
            ModelAndView modelAndView = new ModelAndView("view/course/edit");
            modelAndView.addObject("course", course.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("view/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-course")
    public ModelAndView updateCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        ModelAndView modelAndView = new ModelAndView("view/course/edit");
        modelAndView.addObject("course", course);
        modelAndView.addObject("message", "Course updated successfully");
        return modelAndView;
    }

    // TODO: 24-May-23 Delete
    @GetMapping("/delete-course/{courseId}")
    public ModelAndView showDeleteForm(@PathVariable Integer courseId) {
        Optional<Course> course = Optional.ofNullable(courseService.findById(courseId));
        if (course.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/course/delete");
            modelAndView.addObject("course", course.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("view/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-course")
    public String deletecourse(@ModelAttribute("course") Course course) {
        courseService.delete(course);
        return "redirect:/course/show";
    }

    @GetMapping(value = "/search")
    public ModelAndView showListSearch(@PageableDefault(value = 3, sort = "courseName") Pageable
                                               pageable, @RequestParam(value = "search", required = false) String name) {
        Page<Course> courses = courseService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("view/course/search");
        modelAndView.addObject("courses", courses);
        if (courses.getContent().size() == 0) {
            modelAndView.addObject("message", "Không tìm thấy lop hoc nào .");
        }
        return modelAndView;
    }
}
