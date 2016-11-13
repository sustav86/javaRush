package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human deda = new Human("Deda", true, 50);
        Human deda2 = new Human("Deda2", true, 70);

        Human baba = new Human("Baba", true, 40);
        Human baba2 = new Human("Baba2", true, 60);

        Human father = new Human("Fa", true, 30);
        Human mother = new Human("Ma", true, 26);

        Human ba1 = new Human("Ba1", true, 10, father, mother);
        Human ba2 = new Human("Ba2", true, 11, father, mother);
        Human ba3 = new Human("Ba3", true, 12, father, mother);

        System.out.println(deda);
        System.out.println(deda2);
        System.out.println(baba);
        System.out.println(baba2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(ba1);
        System.out.println(ba2);
        System.out.println(ba3);
    }

    public static class Human
    {
        private String name;
        private Boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, Boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, Boolean sex, int age)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;

        }

        @Override
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
