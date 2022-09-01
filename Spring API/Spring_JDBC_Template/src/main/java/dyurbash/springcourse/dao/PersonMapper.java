package dyurbash.springcourse.dao;

import dyurbash.springcourse.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {                 //из jdbc .core

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {            //вместо кучи дублированного кода в персонДао инициализируки ресалтсет тут один раз и используем там же в персон дао сколько влезет
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setEmail(resultSet.getString("email"));
        person.setId(resultSet.getInt("age"));

        //либо вместо создания этого класса, в подобной ситуации, мы можем передавать вместо него готовый класс BeanPropertyRowMapper(Person.class) - и не нужно будет так тривиально заполнять каждое поле

        return person;
    }
}
