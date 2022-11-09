package org.example;


import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

/////////////////////////////////////////////////////////////////////////////////////

            Principal principal = session.get(Principal.class, 1);
            System.out.println(principal.getSchool());
/////////////////////////////////////////////////////////////////////////////////////

            School school = session.get(School.class, 1);
            System.out.println(school.getPrincipal());

/////////////////////////////////////////////////////////////////////////////////////

            Principal principal1 = new Principal("test", 30);
            School school1 = new School(77777);

            principal.setSchool(school1);

            session.save(principal1);

/////////////////////////////////////////////////////////////////////////////////////////////

            School school2 = session.get(School.class, 1);
            school2.setPrincipal(new Principal("erge", 20));
            session.update(school2);


//////////////////////////////////////////////////////////////////////////////////////



            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
