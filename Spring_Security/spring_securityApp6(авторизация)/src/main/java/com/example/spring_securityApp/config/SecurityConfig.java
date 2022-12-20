package com.example.spring_securityApp.config;


import com.example.spring_securityApp.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//   АВТОРИЗАЦИЯ
//1)при конфигурации более специфичные правла должны стоять выше более общих ( .antMatchers("/auth/login", "/auth/registration","/error").permitAll()    //указываем на какие страницы мы можем пускать неаутентифицированных пользователей
//                .anyRequest().authenticated()) - если поменять местами пользователя вообще никуда не пустит
//общими словами: разделяем права между пользователями
//        структура наполнения таблицы для нашего проекта:

//       - ALTER TABLE Person ADD COLUMN role varchar NOT NULL


http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN") //тут спринг поймет что это роли из таблицы в бд
        .antMatchers("/auth/login", "/auth/registration","/error").permitAll()    //указываем на какие страницы мы можем пускать неаутентифицированных пользователей
        .anyRequest().hasAnyRole("USER", "ADMIN")
        .and()
        .formLogin().loginPage("/auth/login")         //наша стартовая страница
        .loginProcessingUrl("/process_login")                //("/process_login") - указываем в форме представления куда мы ее посылаем
        .defaultSuccessUrl("/hello", true)      //если все хорошо отправляемся сюда
        .failureUrl("/auth/login?error")          //если ошибка то будет выведена надпись из формы представления где мы указывали ерор
        .and()
        .logout().logoutUrl("/logout")
        .logoutSuccessUrl("/auth/login");  //процесс разлогирования человека
        //при переходе на этот адрес у человека стирается его кукис, в нас стирается его сессия
        //логику логаута мы не реализуем сами, нам нужно только создать кнопку с переходом на этот адрес <a href="/logout">Logout</a>
    }



    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncoder());  //тут получаем зашифрвоанный пароль для сравнения

    }
//шифрование настраиваем тут
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();             //указываем как будем шифорвать пароль
    }

}




