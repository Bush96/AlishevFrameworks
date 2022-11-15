package springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcourse.models.Person;


@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
//    то что чаще будет использоваться на работе (используется для более простых запросов к бд)
//    Все методы для круд генерируются автоматически (под капотом имеет хибернейт)

}
