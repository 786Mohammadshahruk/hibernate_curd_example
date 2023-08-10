package NamedQuery.impl;

import NamedQuery.entity.Person;
import NamedQuery.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class PeronDaoImpl {

    public void addPerson(List<Person> person) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            person.stream().forEach(i -> {
                session.persist(i);
            });
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getPerson() {
        try (Session session = HibernateUtil.getSession()) {
            String Native_Query = "Select * from person_db";

            NativeQuery native_query = session.createNativeQuery(Native_Query, Person.class);
            List<Person> list = native_query.list();
            list.stream().forEach(System.out::println);
        } catch (Exception exception) {

        }
    }

    public void getPersonIdAndName() {
        try (Session session = HibernateUtil.getSession()) {
            String Native_Query = "Select id,name from person_db";
            List<Object[]> list = session.createNativeQuery(Native_Query).list();
            for (Object[] objects : list){
                System.out.println(objects[0]);
                System.out.println(objects[1]);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
