package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {                        //так мы обращаемся к модели


        System.out.println(name + surname);
        model.addAttribute("message", name + surname);                      //после появляется доступ к методу с помощью которого мы м ожем передавать чтото в представление
        //ервое значение ключ, второе его значение

        //<p th:text ="${message}"></p>            -далее в представление таким образом мы обращаемся к контроллеру по ключу аким синтаксисом
        return "first/hello";
    }

    //задание(простейший калькулятор)
    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double) b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("answer", result);

        return "/first/Calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}


