package com.example.moneyexchange;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MoneyExchangeController {
    @GetMapping("/money-exchange")
    private String show() {
        return "money-exchange";
    }

    @PostMapping("/result")
    private String exchange(Model model,
                            @RequestParam("usd") String usd,
                            RedirectAttributes redirect) {
        double usdDouble = Double.parseDouble(usd);
        double vnd = 23.447 * usdDouble;
        model.addAttribute("vnd",vnd);
//        redirect.addFlashAttribute("vnd", vnd);
        return "result";
    }
}
