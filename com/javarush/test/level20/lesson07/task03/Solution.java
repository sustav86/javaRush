package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("I", "S", 20);
        person.setMother(new Person("E", "W", 30));
        person.setFather(new Person("U", "P", 40));
        Person personCh1 = new Person("1", "1", 10);
        Person personCh2 = new Person("1", "1", 10);
        Person personCh3 = new Person("1", "1", 10);
        List<Person> list = new ArrayList<Person>();
        list.add(personCh1);
        list.add(personCh2);
        list.add(personCh3);
        person.setChildren(list);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.tmp"));
        person.writeExternal(oos);
        oos.close();

        Person person2 = new Person();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.tmp"));
        person2.readExternal(ois);
        oos.close();


    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {

        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }
}
