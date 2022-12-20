package com.example.spring_securityApp.security;

import com.example.spring_securityApp.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


//когда работаем  секьюрити принято использовать класс обертку на сущностях
public class PersonDetails implements UserDetails {

    private Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //здесь описываем права человека, при ролях используется такой вид, а при листах Authorities мы бы могли описывать каждое действие которое может осуществять человек
//        а так теперь у нас туту будет либо ROLE_ADMIN or ROLE_USER
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;     //является ли сущность активна
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;      //включен и работает
    }

//для получения данных аутентифицированного пользователя
    public Person getPerson (){
        return this.person;
    }
}
