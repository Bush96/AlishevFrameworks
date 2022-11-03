package org.example;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.TypedQuery;
import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);       //при джоинах классы подключаем так

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


// _______________________запрашиваем Person со списком товаров таблицы item________________
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);
//            session.getTransaction().commit();


// _______________________запрашиваем Item который принадлежит определенному Person ________________

//            Item item = session.get(Item.class, 4);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);
//            session.getTransaction().commit();


// _______________________Добавляем товары с помощью Hibernate ________________
//           ______1 способ ____
//            Item item = new Item("Cat");
//            session.persist(item);
//            item.setOwner(session.get(Person.class, 1));

//           ______2 способ ____
//            Person person = session.get(Person.class, 3);
//            Item item = new Item("Cocks", person);
//            session.persist(item);
//            person.getItems().add(new Item());   //можно и без этого, но есть вероятность проблемы с обновлением данных через хибернейт иза кэширования


// _______________________Создаем нового Person с новым item ________________
//            Person person = new Person("Palych", 25);
//            Person person1 = new Person("Ded", 70);
//
//            Item item = new Item("Glasses", person);
//            Item item1 = new Item("Tooth", person1);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//            person1.setItems(new ArrayList<>(Collections.singletonList(item1)));
//
//            session.persist(person1);
//            session.persist(person);
//
//            session.persist(item);
//            session.persist(item1);


            // _______________________Уадялем товары y Person ________________
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//
//            for (Item i : items) {
//                session.remove(i);
//            }
//
//            person.getItems().clear();


// _______________________Уадялем Person ________________
//            Person person = session.get(Person.class, 4);
//            // for SQL
//            session.remove(person);
//            //for Hibernate cash (светится но работает)
//            person.getItems().forEach(i->i.setOwner(null));
//

// _______________________меняем владельца товара________________
//            Person person = session.get(Person.class, 2);
//            Item item = session.get(Item.class, 1);
//
//            item.getOwner().getItems().remove(item);
//
//            item.setOwner(person);
//            person.getItems().add(item);


// _______________________Cascading________________
// (каскадирование  в хибернейт это такая концепция которая связывает сущности 2 таблиц (при изменении чего то в одной - авт изменялось связанное в другой)
            Person person = new Person("Cascading Test", 99);


            person.addItem(new Item("Milk"));
            person.addItem(new Item("Sigarets"));
            person.addItem(new Item("Sens fo live"));


            session.persist(person);      //при какадировании сохраняем с помощью persist а
//             в классе Person добавляем к аннотациям такое пояснение
//          ((((((((  @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
//            private List<Item> items;)))))))


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
