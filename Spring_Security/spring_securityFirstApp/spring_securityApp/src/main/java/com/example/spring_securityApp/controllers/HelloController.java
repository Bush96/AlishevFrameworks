package com.example.spring_securityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

//во всем этом проекте никаких явных намеков на секьр, но захотя мы перейти на сервер нас попросят ввести пароль и логин,
//так как проек мы строили с добавлением зависимостей секьюра в пом, потому он работает и подключен