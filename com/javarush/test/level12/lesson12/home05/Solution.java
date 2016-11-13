package com.javarush.test.level12.lesson12.home05;

/* Что это? «Кот», «Тигр», «Лев», «Бык», «Корова», «Животное»
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».
Замечание: постарайся определять тип животного как можно более точно.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o)
    {

        if (o instanceof Cat) return ((Cat) o).getName();
        else if (o instanceof Tiger) return ((Tiger) o).getName();
        else if (o instanceof Lion) return ((Lion) o).getName();
        else if (o instanceof Bull) return ((Bull) o).getName();
        else if (o instanceof Cow) return ((Cow) o).getName();
        else return "Животное";

    }

    public static class Cat  extends Animal   //<--Классы наследуются!!
    {
        public String getName() {
            return "Кот";
        }
    }

    public static class Tiger  extends Cat
    {
        public String getName() {
            return "Тигр";
        }
    }

    public static class Lion  extends Cat
    {
        public String getName() {
            return "Лев";
        }
    }

    public static class Bull  extends Animal
    {
        public String getName() {
            return "Бык";
        }
    }

    public static class Cow  extends Animal
    {
        public String getName() {
            return "Корова";
        }
    }

    public static class Animal
    {
        public String getName() {
            return "Животное";
        }
    }
}
