package com.example.spring_securityApp.util;

import com.example.spring_securityApp.models.Person;
import com.example.spring_securityApp.services.PersonDetailsService;
import com.example.spring_securityApp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;


    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    //для ускорения проекта логика валидации хромает, и п отолку стоило бы сделать другой сервис на проверку еловека а не опираться на исклчение
    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (
                personService.loadUserByUsername(person.getUsername()).isPresent()) {
           errors.rejectValue("username","Ашибька");
        }
    }
}