package com.example.demo2.repositories;


import com.example.demo2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
