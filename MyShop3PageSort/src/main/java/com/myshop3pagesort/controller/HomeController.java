package com.myshop3pagesort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView showHomePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }
}