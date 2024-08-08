package com.exalt.section6.controller;

import org.springframework.stereotype.Controller;
// be sure to use this import
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld"; // --> src/main/resources/templates/helloworld.html
    }
}
