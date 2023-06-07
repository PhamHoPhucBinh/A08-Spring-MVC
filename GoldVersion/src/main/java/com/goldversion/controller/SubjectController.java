package com.goldversion.controller;

import com.goldversion.bean.Subject;
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

import java.util.Optional;

@Controller
@RequestMapping(value = "/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    // TODO: 24-May-23 list
    @GetMapping(value = "/show-subject")
    public ModelAndView displayPageSubject(@PageableDefault(value = 3, sort = "subjectName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Subject> subjects = subjectService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/subject/show-subject");
        modelAndView.addObject("subjects", subjects);
        if (subjects.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có môn học nào cả.");
        }
        return modelAndView;
    }

    // TODO: 24-May-23 : create
    @GetMapping("/create-subject")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("view/subject/create-subject");
        modelAndView.addObject("subject", new Subject());
        return modelAndView;
    }

    @PostMapping("/create-subject")
    public ModelAndView saveSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.save(subject);
        ModelAndView modelAndView = new ModelAndView("view/subject/create-subject");
        modelAndView.addObject("subject", new Subject());
        modelAndView.addObject("message", "create successfully");
        return new ModelAndView("redirect:/subject/show-subject");
    }

    // TODO: 24-May-23 : edit
    @GetMapping(value = "/edit-subject/{subjectId}")
    public ModelAndView showPageUpdate(@PathVariable Integer subjectId) {
        Optional<Subject> subject = subjectService.findById(subjectId);
        return new ModelAndView("view/subject/edit-subject", "subject", subject);
    }

    @PostMapping(value = "/edit-subject")
    public String updateSubject(@Validated @ModelAttribute Subject subject, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/subject/edit-subject";
        } else {
            redirectAttributes.addFlashAttribute("message", "Update subject: " + subject.getSubjectName() + " success.");
            subjectService.save(subject);
            return "redirect:/subject/show-subject";
        }
    }

    // TODO: 24-May-23 Delete



    @GetMapping("/delete-subject/{id}")
    public String deleteSubject(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        subjectService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa môn học thành công!");
        return "redirect:/subject/show-subject";
    }

    @GetMapping(value = "/search-subject")
    public ModelAndView showListSearch(@PageableDefault(value = 3, sort = "subjectName") Pageable pageable, @RequestParam(value = "search-subject", required = false) String name) {
        Page<Subject> subjects = subjectService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("view/subject/search-subject");
        modelAndView.addObject("subjects", subjects);
        if (subjects.getContent().size() == 0) {
            modelAndView.addObject("message", "Không tìm thấy môn học nào .");
        }
        return modelAndView;
    }
}
