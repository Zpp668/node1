package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody            //写给浏览器
    @RequestMapping("/hello")//接受浏览器的请求/hello
    public String Hello(){
        return "Hello Word!";
    }
}
