package dyurbash.springcourse.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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

    ////////////////////
    ///////Тестируем производительность пакетной вставки
    ////////////////////

    public void testMultipleUpdate() {                                 //создаем метод который будет возвращать список из людей
        List<Person> people = create1000people();

        long before = System.currentTimeMillis();

        for (Person person : people) {
            jdbcTemplate.update("INSERT INTO Person VALUES (?, ?,?,?)", person.getId(), person.getName(),     //люди в список будут добавляться по одному
                    person.getAge(), person.getEmail());
        }

        long after = System.currentTimeMillis();
        System.out.printf("time" + (after - before));
    }

    public void testBatchUpdate() {                  //здесь вставляем в бд 1000 записей  оодним пакетом
        List<Person> people = create1000people();
        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {             //юда передаем значения которые попадут в пакет
                preparedStatement.setInt(1, people.get(i).getId());        //вставляем в этот запрос значения для каждого человека
                preparedStatement.setString(2, people.get(i).getName());
                preparedStatement.setInt(3, people.get(i).getAge());
                preparedStatement.setString(4, people.get(i).getEmail());

            }

            @Override
            public int getBatchSize() {                //должны вернуть размер пакета
                return people.size();
            }
        });

        long after = System.currentTimeMillis();
        System.out.printf("time" + (after - before));
    }

    private List<Person> create1000people() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            people.add(new Person(i, "name" + i, 30, "test" + i + " mail.ru"));
        }
        return people;
    }
}