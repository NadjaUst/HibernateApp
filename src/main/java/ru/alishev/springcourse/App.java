package ru.alishev.springcourse;

import ru.alishev.springcourse.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // adding person and item
        try {
            session.beginTransaction();

            Person newPerson = new Person("Test cascading 3", 30);
            newPerson.addItem(new Item("Test cascading item 10"));
            newPerson.addItem(new Item("Test cascading item 20"));
            newPerson.addItem(new Item("Test cascading item 30"));

            session.save(newPerson);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}

