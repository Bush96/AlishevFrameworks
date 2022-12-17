package com.example.spring_securityApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    //здесь будет лежать наша кастомная страница, ее видет мы делаем сами в представлении
    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }
}
