package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller                   //помечаем контроллером создаем бин
public class FirstController {

    @GetMapping("/hello")              //указываем что введя пользователь хэлло вызовется этот метод
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodBye")
    public String goodByePage() {
        return "first/goodBye";
    }
}



//                описание к hello.html
//<!DOCTYPE html>
//<html lang="en">
//<head>
//<meta charset="UTF-8">
//<title>Hello</title>               //ссылка на страницу
//</head>
//<body>
//Hello!                 //что выведется на странице
//
//<a href="/goodbye">Say goodbye</a> or <a href="/exit"></a>                //добавляем на выход ссылку, по которй можно перейти на страницу goodbyt or exit
//</body>
//</html>