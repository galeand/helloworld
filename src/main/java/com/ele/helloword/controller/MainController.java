package com.ele.helloword.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger("MainController.class");

    @ResponseBody
    @RequestMapping("/")
    public String sayHello() {
        String msg = "Welcome, this is hello-world";
        return msg;
    }

}
