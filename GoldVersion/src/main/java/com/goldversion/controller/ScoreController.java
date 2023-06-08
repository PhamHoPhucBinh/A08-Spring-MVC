package com.goldversion.controller;

import com.goldversion.bean.Score;
import com.goldversion.bean.Student;
import com.goldversion.bean.Subject;
import com.goldversion.service.score.ScoreService;
import com.goldversion.service.student.StudentService;
import com.goldversion.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Optional;

@Controller
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "/show-score")
    public ModelAndView displayPageScore(@PageableDefault(value = 3, sort = "score", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Score> scores = scoreService.showAll(pageable);
        Iterable<Student> students = studentService.findAll();
        Iterable<Subject> subjects = subjectService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/score/show-score");
        modelAndView.addObject("students", students);
        modelAndView.addObject("subjects", subjects);
        modelAndView.addObject("scores", scores);
        if (scores.getContent().size() == 0) {
            modelAndView.addObject("message", "There is NO data!");
        }
        return modelAndView;
    }

    @GetMapping("/create-score")
    public ModelAndView showCreateForm() {
        Iterable<Student> students = studentService.findAll();
        Iterable<Subject> subjects = subjectService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/score/create-score");
        modelAndView.addObject("subjects", subjects);
        modelAndView.addObject("students", students);
        modelAndView.addObject("score", new Score());
        return modelAndView;
    }

    @PostMapping("/create-score")
    public ModelAndView saveScore(@Valid @ModelAttribute("score") Score score, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("view/score/create-score");
            modelAndView.addObject("subjects", subjectService.findAll());
            modelAndView.addObject("students", studentService.findAll());
            modelAndView.addObject("message", "dữ liệu không hợp lệ");
            return modelAndView;
        } else {
            scoreService.save(score);
            ModelAndView modelAndView = new ModelAndView("view/score/create-score");
            modelAndView.addObject("subjects", subjectService.findAll());
            modelAndView.addObject("students", studentService.findAll());
            modelAndView.addObject("score", new Score());
            modelAndView.addObject("message", "Create Score: " + score.getId() + " success.");
            return modelAndView;
        }
    }

    @GetMapping(value = "/edit-score/{id}")
    public ModelAndView showPageUpdate(@PathVariable Integer id) {
        Optional<Score> score = scoreService.findById(id);
        if (score.isPresent()) {
            Iterable<Student> students = studentService.findAll();
            Iterable<Subject> subjects = subjectService.findAll();
            ModelAndView modelAndView = new ModelAndView("view/score/edit-score");
            modelAndView.addObject("students", students);
            modelAndView.addObject("subjects", subjects);
            modelAndView.addObject("score", score.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/edit-score")
    public String updateScore(@Validated @ModelAttribute Score score, BindingResult
            bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/score/edit-score";
        } else {
            redirectAttributes.addFlashAttribute("message", "Update Score: " + score.getId() + " success.");
            scoreService.save(score);
            return "redirect:/score/show-score";
        }
    }

    @GetMapping("/delete-score/{id}")
    public String deleteScore(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        scoreService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/score/show-score";
    }


}
