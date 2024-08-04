package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("")
    public String testMapping(){
        return "Hellooooooo";
    }

    @GetMapping("/devTools")
    public String devToolsTest(){
        return "devTools is a good man :)";
    }
}
