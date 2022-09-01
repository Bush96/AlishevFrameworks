package dyurbash.springcourse.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import dyurbash.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;      //создаем поле тамплайта


    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {                                 //вместо кучи кода получаем одну строку
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());                          //RowMapper создаем сами в отдельном классе
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id =?", new Object[]{id}, new PersonMapper())      //new Object[]{id} - поставляемый ид
                .stream().findAny().orElse(null);                 //  .stream().findAny().orElse(null) - если человек снужным айди будет найден - возвращаем его, если нет - нулл
    }

    public void save(Person person) {


        jdbcTemplate.update("INSERT INTO Person VALUES (1, ?,?,?)", person.getName(),
                person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?", updatedPerson.getName(),
                updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}