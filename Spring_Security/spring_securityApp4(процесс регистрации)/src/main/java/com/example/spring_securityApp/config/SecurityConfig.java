package com.example.spring_securityApp.config;


import com.example.spring_securityApp.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //зедсь настраиваем то какую форму для логина будем использовать
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       кнфигурируем сам спринг секьюр (где страница входа, страница ошибки и т п )
//        конфигурируем авторизацию


http.csrf().disable()//отключаем защиту от межсайтовой подделки запросов(далее в курсе все это настроим)
        .authorizeRequests()
        .antMatchers("/auth/login","/error", "/auth/registration").permitAll()    //указываем на какие страницы мы можем пускать неаутентифицированных пользователей
        .anyRequest().authenticated()
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
        auth.userDetailsService(personDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();             //указываем как будем шифорвать пароль
    }

}




//<form name="f" th:method="POST" th:action="/process_login">
//<label for="username">Enter name: </label>                        обязательно юсер наэй в имени!
//<input type="text" name="username" id="username"/>
//<br/>
//<label for="password">Enter password: </label>
//<input type="password" name="password" id="password"/>     обязательно пассворд в пароле ! иначе секьюр их не увидит
//<br/>
//<input type="submit" value="login!"/>
//
//<div th:if="${param.error}" style="color: red">
//        Uncorrect password
//</div>
//</form>

