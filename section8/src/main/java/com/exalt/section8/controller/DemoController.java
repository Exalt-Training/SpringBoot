package com.exalt.section8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){
        System.out.println("-----------------------------------------------------------------");
//        return "plain-login";
        return "fancy-login";
    }
}
