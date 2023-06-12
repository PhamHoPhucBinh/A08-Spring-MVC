package com.samplex.controller;

import com.samplex.model.Question;
import com.samplex.model.QuestionType;
import com.samplex.service.question.QuestionService;
import com.samplex.service.questiontype.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionTypeService questionTypeService;

    // TODO: 24-May-23 list
    @GetMapping(value = "/show-question")
    public ModelAndView displayPageQuestion(@PageableDefault(value = 3, sort = "status", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Question> questions = questionService.showAll(pageable);
        Iterable<QuestionType> questionTypes = questionTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/question/show-question");
        modelAndView.addObject("questionTypes", questionTypes);
        modelAndView.addObject("questions", questions);
        if (questions.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có câu hỏi nào cả.");
        }
        return modelAndView;
    }

    // TODO: 24-May-23 : create
    @GetMapping("/create-question")
    public ModelAndView showCreateForm() {
        Iterable<QuestionType> questionTypes = questionTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/question/create-question");
        modelAndView.addObject("questionTypes", questionTypes);
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @PostMapping("/create-question")
    public ModelAndView saveQuestion(@Valid @ModelAttribute("question") Question question, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("view/question/create-question");
            modelAndView.addObject("questionTypes", questionTypeService.findAll());
            modelAndView.addObject("message", "dữ liệu không hợp lệ");
            return modelAndView;
        }
        questionService.save(question);
        ModelAndView modelAndView = new ModelAndView("view/question/create-question");
        modelAndView.addObject("questionTypes", questionTypeService.findAll());
        modelAndView.addObject("question", new Question());
        modelAndView.addObject("message", "create successfully");
        return new ModelAndView("redirect:/question/show-question");
    }

    // TODO: 24-May-23 : edit
    @GetMapping(value = "/edit-question/{id}")
    public ModelAndView showPageUpdate(@PathVariable Integer id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            Iterable<QuestionType> questionTypes = questionTypeService.findAll();
            ModelAndView modelAndView = new ModelAndView("view/question/edit-question");
            modelAndView.addObject("questionTypes", questionTypes);
            modelAndView.addObject("question", question.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("view/error-404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/edit-question")
    public String updateQuestion(@Validated @ModelAttribute Question question, BindingResult
            bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/question/edit-question";
        } else {
            redirectAttributes.addFlashAttribute("message", "Update Question: " + question.getQuestionId() + " success.");
            questionService.save(question);
            return "redirect:/question/show-question";
        }
    }

    // TODO: 24-May-23 Delete


    @GetMapping("/delete-question/{id}")
    public String deleteQuestion(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        questionService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete Succesfully!");
        return "redirect:/question/show-question";
    }

    @GetMapping(value = "/search-question")
    public ModelAndView showListSearch(@PageableDefault(value = 3, sort = "status")
                                       Pageable pageable, @RequestParam(value = "search-question", required = false) String name) {
        Page<Question> questions = questionService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("view/question/search-question");
        modelAndView.addObject("questions", questions);
        if (questions.getContent().size() == 0) {
            modelAndView.addObject("message", " There is no found result !");
        }
        return modelAndView;
    }
    @GetMapping(value = "/search-type")
    public ModelAndView showListSearchType(@PageableDefault(value = 3, sort = "status")
                                       Pageable pageable, @RequestParam(value = "search-type", required = false) String name) {
        Page<Question> questions = questionService.findByType(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("view/question/search-question");
        modelAndView.addObject("questions", questions);
        if (questions.getContent().size() == 0) {
            modelAndView.addObject("message", " There is no found result !");
        }
        return modelAndView;
    }
}
