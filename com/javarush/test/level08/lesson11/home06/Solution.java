package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> childList = new ArrayList<Human>();

        Human child1 = new Human("First", true, 7, childList);
        Human child2 = new Human("Second", false, 10, childList);
        Human child3 = new Human("Third", true, 11, childList);

        ArrayList<Human> children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human mother = new Human("Mother", false, 30, children);
        Human father = new Human("Father", true, 35, children);

        ArrayList<Human> motherList = new ArrayList<Human>();
        motherList.add(mother);

        ArrayList<Human> fatherList = new ArrayList<Human>();
        fatherList.add(father);

        Human grandpa1 = new Human("Vasya", true, 60, motherList);
        Human grandpa2 = new Human("Fedya", true, 65, fatherList);

        Human grandma1 = new Human("Mawa", true, 55, motherList);
        Human grandma2 = new Human("Asy", true, 54, fatherList);

        System.out.println(grandpa1);
        System.out.println(grandpa2);

        System.out.println(grandma1);
        System.out.println(grandma2);

        System.out.println(mother);
        System.out.println(father);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, Boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, Boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
