package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller  //помечаем контроллером создаем бин
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")              //указываем что введя пользователь хэлло вызовется этот метод
    public String helloPage(@RequestParam(value = "name", required = false) String name,         //с помощью  @RequestParam
                            @RequestParam(value = "surname", required = false) String surname) {
//        String name = request.getParameter("name");             с помощью  HttpServletRequest
//        String surname =request.getParameter("surname");
//
       System.out.println(name + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}


