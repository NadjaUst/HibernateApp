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

            Person newPerson = new Person("Tom Hibernate", 50);
            Item newItem = new Item("Apple Hibernate", newPerson);
            newPerson.setItems(new ArrayList<>(Collections.singletonList(newItem)));

            session.save(newPerson);
            session.save(newItem);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

        //adding item
/*        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 2);
            Item newItem = new Item("MacBook", person);
            person.getItems().add(newItem); // updating cash hibernate
            session.save(newItem);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

       //get person from item
 /*        try {
            session.beginTransaction();

            Item item = session.get(Item.class, 5);
            System.out.println(item);
            Person person = item.getOwner();
            System.out.println(person);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }*/

        //get person`s items
/*        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 3);
            System.out.println(person);
            person.getItems().forEach(System.out::println);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }*/
    }
}

