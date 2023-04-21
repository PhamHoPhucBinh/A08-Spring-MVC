package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DictionaryService;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("search")
    public ModelAndView result(@RequestParam String search){
        String result= dictionaryService.search(search);
        return new ModelAndView("result", "result", result == null? "Not found": result);
    }
}
