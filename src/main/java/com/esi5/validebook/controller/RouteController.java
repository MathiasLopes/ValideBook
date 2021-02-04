package com.esi5.validebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    
    @GetMapping("/home")
    public String home(){
        return "home/home";
    }

    @GetMapping("/specialiste")
    public String specialiste(){
        return "specialiste/specialiste";
    }
}
