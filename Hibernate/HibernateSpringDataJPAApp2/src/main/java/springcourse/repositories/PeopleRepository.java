package springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcourse.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
//    то что чаще будет использоваться на работе (используется для более простых запросов к бд)
//    Все методы для круд генерируются автоматически (под капотом имеет хибернейт)

    List<Person> findByName(String name);    //пример кастомных методов( любые не сделаешь и делать их нужно по правилам и перечню на оф сайте)

    List<Person> findByNameOrderByAge(String name);

    List<Person> findByAge(int age);

    List<Person> findByNameStartingWith(String startingWith);

    List<Person> findByNameOrAge(String name, int age);
}
