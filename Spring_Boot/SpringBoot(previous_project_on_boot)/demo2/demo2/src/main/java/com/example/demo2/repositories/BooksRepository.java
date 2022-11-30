package com.example.demo2.repositories;


import com.example.demo2.models.Book;
import com.example.demo2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByOwner(Person owner);
    List<Book> findByTitleStartingWith (String title);

}
