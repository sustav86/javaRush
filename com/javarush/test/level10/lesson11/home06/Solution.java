package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

        Human human = new Human();
        Human human1  = new Human("Vasya");
        Human human2  = new Human("Vasya", "man");
        Human human3  = new Human("Masha", "woman", 19);
        Human human4  = new Human("Petya", "man", 20, false);
        Human human5  = new Human("Kolya", "man", 40, true, 1234562, 'd');
        Human human6  = new Human("Ninka", "woman", 39, true, 'd');
        Human human7  = new Human("Kolya", "man", 40, true, 1234562);
        Human human8  = new Human("woman", 23, false);
        Human human9  = new Human("man", true);
        Human human10  = new Human("man", 12);


    }

    public static class Human
    {
        private String name;
        private String sex;
        private int age;
        private Boolean married;
        private long zp;
        private char in;

        public Human()
        {

        }

        public Human(String name)
        {
            this.name = name;

        }

        public Human(String name, String sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, String sex, int age, Boolean married)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.married = married;
        }

        public Human(String name, String sex, int age, Boolean married, long zp, char in)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.married = married;
            this.zp = zp;
            this.in = in;
        }

        public Human(String name, String sex, int age, Boolean married, char in)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.married = married;
            this.in = in;
        }

        public Human(String name, String sex, int age, Boolean married, long zp)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.married = married;
            this.zp = zp;

        }

        public Human(String sex, int age, Boolean married)
        {
            this.sex = sex;
            this.age = age;
            this.married = married;
        }

        public Human(String sex, Boolean married)
        {
            this.sex = sex;
            this.married = married;
        }

        public Human(String sex, int age)
        {
            this.sex = sex;
            this.age = age;

        }


    }
}
