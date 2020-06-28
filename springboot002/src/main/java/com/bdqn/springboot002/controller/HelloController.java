package com.bdqn.springboot002.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//==@Reseponsebody+@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Word";
    }
}
