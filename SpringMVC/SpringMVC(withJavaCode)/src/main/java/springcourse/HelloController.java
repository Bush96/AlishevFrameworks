package springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {                 //все остается как и с конфигурацией по ХМЛ
    @GetMapping("/hello-world")               //когда пользователь в строке впишет хэлло ворлд то вызовется этот метод
    public String sayHello(){
return "Hello_world";
    }
}
