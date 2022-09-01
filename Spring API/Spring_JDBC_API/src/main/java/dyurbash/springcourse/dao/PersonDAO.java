package dyurbash.springcourse.dao;

import org.springframework.stereotype.Component;
import dyurbash.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";      //далее это будет храниться в отдельных файле
    private static final String USERNAME = "postgres";                             //
    private static final String PASSWORD = "evumes";                               //

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");    //на всякий случай делаем
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);              //так настраиваем соединение к бд
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();              //сюда будем класт людей которые достаем из бд

        try {
            Statement statement = connection.createStatement();      //заводим этот обьект (он содержит запрос к бд)
            String SQL = "SELECT * FROM Person";                    //запрос который мы будем делать в методе дао
            ResultSet resultSet = statement.executeQuery(SQL);      //заводим обьект в котором храниться результат запроса с бд

            while (resultSet.next()) {                               //так строки переводим в обьекты
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));             //-!

                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        Person person = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id =? ");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();             //будет содержать все строки полученные по этому запросу к бд

            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setId(resultSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void save(Person person) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person VALUES(1, ?, ?,?) ");          //ример работы защиты от СКЬЛ иньекций с preparedStatement
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();                                //так обновляются данные в бд
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name  = ? , age =?, email = ?, WHERE id =?");
            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM Person WHERE id = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}