package org.example;

import jakarta.persistence.TypedQuery;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);        //Подключаем класс модели и ресоурс проперти( явно не видно, но так и есть)

        SessionFactory sessionFactory = configuration.buildSessionFactory();  //отсюда можем получить сессию на работу с бд хайбернейтом
        Session session = sessionFactory.getCurrentSession();

        //        _____________________касаемо всохранения обьектов в бд___________________
//        try {
//            session.beginTransaction();
//
//            Person person = new Person("KO", 22);
//            Person person2 = new Person("Ko", 25);
//            Person person3 = new Person("By", 28);
//
//            session.persist(person);                       //было save стало persist
//            session.persist(person2);
//            session.persist(person3);
//
//            session.getTransaction().commit();
//        } finally {
//            session.close();
//        }

//        _____________________касаемо выдергивания обьекта из бд___________________
//        try {
//            session.beginTransaction();
//
//            Person person = session.get(Person.class, 1);        //передаем сущность и первичный ключ по которому мы ходим получить что ищем
//
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//
//            session.getTransaction().commit();
//
//        } finally {
//            sessionFactory.close();
//        }
//        _____________________касаемо изменения и удаления значений полей в бд___________________
//        try {
//            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            person.setName("Artiom");               //этого достаточно, больше ничего вызывать не нужно, поле коммита значение изменится автоматически
//            session.delete(person);          //так удаляем, было delete
//            session.getTransaction().commit();
//        } finally {
//            session.close();
//        }
//        _____________________касаемо получения ИД добавленного обьекта в  бд___________________
//        try {
//            session.beginTransaction();
//            Person person = new Person("Test 1", 60);
//            session.persist(person);
//
//            session.getTransaction().commit();
//
//            System.out.println(person.getId());          //после комита можем сразу обратиться к бд и выдернуть айди нового обьекта
//        } finally {
//            session.close();
//        }

        //        _____________________лексика HQL( нестандартные запросы)___________________
        try {
            session.beginTransaction();
            List<Person> people = session.createQuery("From Person").getResultList();         //запрос на выборку всех людей
//            session.createQuery("update Person set name='Kek' where age<50").executeUpdate();               //запрос на обновление значений
//            session.createQuery("delete From Person where age>50").executeUpdate();               //запрос на удаление
            session.getTransaction().commit();
            for (Person p : people) {
                System.out.println(p);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        
    }
}
