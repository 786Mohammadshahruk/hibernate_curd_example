package NamedQuery.client;

import NamedQuery.entity.Person;
import NamedQuery.impl.PeronDaoImpl;

import java.util.Arrays;
import java.util.List;

public class SavePersonDataClientTest {

    public static void main(String[] args) {

        PeronDaoImpl peronDao = new PeronDaoImpl();
        peronDao.addPerson(getPerson());

    }


    private static List<Person> getPerson() {
        Person person1 = new Person();
        person1.setAddress("Delhi");
        person1.setName("Arun");
        person1.setNickName("Arun");
        person1.setDob("21-01-1999");

        Person person2 = new Person();
        person2.setAddress("Delhi");
        person2.setName("Ajay");
        person2.setNickName("kumar");
        person2.setDob("21-01-2000");
        return Arrays.asList(person1, person2);
    }
}
