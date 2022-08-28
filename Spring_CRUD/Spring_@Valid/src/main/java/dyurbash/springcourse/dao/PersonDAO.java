package dyurbash.springcourse.dao;

import org.springframework.stereotype.Component;
import dyurbash.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", "@asdga", 16));
        people.add(new Person(++PEOPLE_COUNT, "Dom", "@aggngga", 22));
        people.add(new Person(++PEOPLE_COUNT, "Pom", "@asdsadfa", 80));
        people.add(new Person(++PEOPLE_COUNT, "Com", "@a34ddgga", 5));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToUpdateted = show(id);

        personToUpdateted.setName(updatePerson.getName());
        personToUpdateted.setAge(updatePerson.getAge());
        personToUpdateted.setEmail(updatePerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}