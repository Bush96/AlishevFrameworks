package com.example.spring_securityApp.repositories;

import com.example.spring_securityApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional <Person> findByName (String name);
}
