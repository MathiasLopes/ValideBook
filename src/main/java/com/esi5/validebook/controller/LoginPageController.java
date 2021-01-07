package com.esi5.validebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/")
    public String index(){
        return "account/login";
    }

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }
}

