package com.bdqn.springboot003.controller;

import com.bdqn.springboot003.exception.UserNotExiteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HellController {
    @ResponseBody
    @RequestMapping("/hello")
    public String Hello(@RequestParam("user") String user) {
        if (user.equals("aaa")){
            throw new UserNotExiteException();
        }
        return "success";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好！</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi"));
        return "success";
    }
}


