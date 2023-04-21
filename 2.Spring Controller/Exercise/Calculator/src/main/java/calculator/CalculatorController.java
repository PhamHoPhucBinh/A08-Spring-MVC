package calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @PostMapping("calculator")
    public String calculator(Model model, @RequestParam("num1") Double num1, @RequestParam("num2") Double num2, @RequestParam("operator") String operator) {
        String result = "";

        switch (operator) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                result = num2 == 0 ? "Cannot division to zero" : String.valueOf(num1 / num2);
                break;
        }

        model.addAttribute("result", result);
        return "index";
    }
}
