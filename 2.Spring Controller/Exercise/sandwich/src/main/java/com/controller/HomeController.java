package com.controller;

import com.model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping
    public String home(Model model){
        Test test= new Test();
        model.addAttribute("test", test);
        return "index";
    }

    @PostMapping("save")
    public ModelAndView save(String condiment){
        ModelAndView modelAndView= new ModelAndView("index", "condiment", condiment);
        return modelAndView;
    }
}
