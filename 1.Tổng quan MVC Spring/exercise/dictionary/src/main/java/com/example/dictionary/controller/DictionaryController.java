package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Scanner;

@Controller
public class DictionaryController {
    @GetMapping("home")
    private String show() {
        return "formInput";
    }

    @PostMapping("/result")
    private String translate(Model model, @RequestParam("input") String input, RedirectAttributes redirect) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("red", "đỏ");
        dictionary.put("blue", "xanh");
        dictionary.put("green", "lục");
        dictionary.put("yellow", "vàng");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập từ cần tra: ");
        String inputEnglish = scanner.nextLine();

        String output = dictionary.get(inputEnglish);

        if (output != null) {
            System.out.println("Từ \"" + inputEnglish + "\" có nghĩa là \"" + output + "\"");
        } else {
            System.out.println("Từ \"" + inputEnglish + "\" không tồn tại trong từ điển");
        }
        redirect.addFlashAttribute("output", output);
        return "output";
    }
}
