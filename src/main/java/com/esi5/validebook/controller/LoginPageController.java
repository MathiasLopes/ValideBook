package com.esi5.validebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/")
    public String index(){
        //Permet de diriger l'utiisateur vers la page de connexion lorsqu'il vient sur le site sans url précise
        return "account/login";
    }

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }
}

