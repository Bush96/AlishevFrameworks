package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp1Application {
//	Короче говоря спринг бут берет на себя практически всю конфигурацию изза чего прост в использовании, но и при возниконвении ошибок они тяжелее исправляются изза высоко уровня абстракции
//	1.не нужно конфигурировать,на сайте springInitializ подготавливаем проект и запускаем
//	2.не будет проблем с несовместимостью зависимостей, бут обьединяет в себе 100 рабочие друг с другом завиимости в одну крупную и добавляет
//	3.имеется встроенный сервер, не нужно обораивать проект в вар фай и отправлять на сервер как раньше
//	4.проект собирается автоматически и запускается одной кнопкой(томкат и остальное подключаются автоматически, все остальные функции остаются теми же что и раньше как без бута
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp1Application.class, args);
	}

}
