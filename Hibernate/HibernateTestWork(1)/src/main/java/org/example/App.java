package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//__________________________1__________________________(С помощью Hibernate получите любого режиссера, а затем получите список его фильмов.)
//            Director director = session.get(Director.class, 1);
//            List<Movie> movie = director.getMovieList();


//__________________________2__________________________(Получите любой фильм, а затем получите его режиссера.)
//            Movie movie= session.get(Movie.class,1);
//            Director director = movie.getBoss();

//__________________________3__________________________(Добавьте еще один фильм для любого режиссера.)
//            Movie movie = new Movie("Test Movie", 2022);
//            session.persist(movie);
//            movie.setBoss(session.get(Director.class,3));

//__________________________4__________________________(Создайте нового режиссера и новый фильм и свяжите эти сущности.)
//            Director director = new Director("Test Director", 2000);
//            Movie movie = new Movie("Test Movie2", 2000);
//            session.persist(director);
//            session.persist(movie);
//            movie.setBoss(director);
//            director.setMovieList(Collections.singletonList(movie));
//__________________________5__________________________(Смените режиссера у существующего фильма.)
//            Movie movie = session.get(Movie.class, 2);
//            Director director = session.get(Director.class, 3);
//            session.remove(movie.getBoss());
//            movie.setBoss(director);
//
//            director.setMovieList(Collections.singletonList(movie));
//__________________________6__________________________(Удалите фильм у любого режиссера.)
//            Movie movie = session.get(Movie.class, 1);
//            session.remove(movie);
//

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
