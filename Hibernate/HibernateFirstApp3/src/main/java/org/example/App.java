package org.example;

import jakarta.persistence.ManyToMany;
import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//_____________Касаемо lazy and Eager загрузок__________________
//            @ManyToMany (fetch = FetchTipe.Eager - не ленивая загузка(в запросе подтягиваются ве связанные сущности из других таблиц
//            @ManyToMany (fetch = FetchTipe.Lazy -ленивая загузка(в запросе не подтягиваются ве связанные сущности из других таблиц
//            Отличие в производительности, поэтому нужно думать что выбирать
//   Hibernat.initialize (person.getItems()) - используем эту строку при ленивой загрузке чтобы подгрузить связанные сущности которые мы сможем спользовать вне сессии
//            так как вне сессии при ленивой загрузке вызывать связанные сущности не получится (при игл получится)

//            открывать сесий мы можем сколько угодно, только следующая сессия не запоинает обьекты который находились в предыдущей сесси
//                    чтобы это исправить - мы используем merch

//            person = (Person) session.merge(person)  - таким образом мы снова можем обратиться к тому же обьекты из предыдушей сессии
//                    все это нужно например для того чтобы подгрузить в лэйзи загрузке связанные товары (если выше нам это не требовалось) в процессе выполнения программы






//_____________Remove each other__________________(1  easy version)
//            Actor actor = session.get(Actor.class, 1);
//            Movie movie = session.get(Movie.class, 1);
//            movie.getActors().remove(actor);
//            actor.getMovies().remove(movie);

//_____________Remove each other__________________(2  hard version)
            Actor actor = session.get(Actor.class, 2);
            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0); //remove by index
            movieToRemove.getActors().remove(actor);      //by object

            //this vesrsion need hashCode-equals realisation

//_______________________________________________________________
//            Actor actor = new Actor("Test Actor", 2000);
//            Actor actor1 = new Actor("Test Actor2", 1999);
//
//            movie.setActors(new ArrayList<>(List.of(actor, actor1)));
//            actor.setMovies(Collections.singletonList(movie));
//            actor1.setMovies(Collections.singletonList(movie));
//
//            session.persist(movie);
//            session.persist(actor);
//            session.persist(actor1);

//            ___________________________________________

//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());
//            Actor actor = session.get(Actor.class, 2);
//            System.out.println(actor.getMovies());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}