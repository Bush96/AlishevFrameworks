package com.example.spring_securityApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//
//CSRF (Cross-Site Request Forgery) - межсайтовая подделка запроса
//1) всегда используется Cookies same_origin policy (штука которая  обеспечивает тот факт что кукис одного сайта не может узнать другой сайт)
//это обеспечивает защиту но недостаточную (злоумышленник завладев вашими кукис могут использовать их  создав поддельную форму представления и натворить делов)
//2) защита: 1) встраиваем в каждую форму специальный токен, который должен совпасть при возвращении формы от пользователя!
//3)ясно добавялем этот токен в форму аутентификации, в остальные формы он будет добавлен автоматически
//4) вот поле  <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
//5)меняет форму разлогирования с гет запроса на форму пост запроса (смотертьв представлении)




@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

}
