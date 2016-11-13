package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("1", "2", "uk", Sex.MALE);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.tmp"));
        oos.writeObject(person);
        oos.flush();
        oos.close();

//        System.out.println(person.firstName);
//        System.out.println(person.lastName);
//        System.out.println(person.fullName);
//        System.out.println(person.greetingString);
//        System.out.println(person.country);
//        System.out.println(person.sex);
//        System.out.println(person.outputStream);
//        System.out.println(person.logger);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.tmp"));
        Person personLoad = (Person) ois.readObject();
//        personLoad.fullName = String.format("%s, %s", personLoad.lastName, personLoad.firstName);
//        personLoad.outputStream = System.out;
//        personLoad.logger = Logger.getLogger(String.valueOf(Person.class));
//        if(person.equals(personLoad))
//            System.out.println("Они равны!");
//        else
//            System.out.println("Они не равны!");
//        System.out.println(personLoad.firstName);
//        System.out.println(personLoad.lastName);
//        System.out.println(personLoad.fullName);
//        System.out.println(personLoad.greetingString);
//        System.out.println(personLoad.country);
//        System.out.println(personLoad.sex);
//        System.out.println(personLoad.outputStream);
//        System.out.println(personLoad.logger);
        ois.close();

    }

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;
        private static final long serialVersionUID = 123456789;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
