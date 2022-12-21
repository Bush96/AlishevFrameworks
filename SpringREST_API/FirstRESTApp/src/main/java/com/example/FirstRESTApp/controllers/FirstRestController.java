package com.example.FirstRESTApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController          //выполняет ту же функцию что и responseBody только для всего класса
@RequestMapping("/api")
public class FirstRestController {

//    @ResponseBody        // c этой аннотацией контроллер возвращает не страницу представления а именно переданную строку
    @GetMapping("/sayHello")
    public String sayHello() {
return "Hello World";
    }


}




