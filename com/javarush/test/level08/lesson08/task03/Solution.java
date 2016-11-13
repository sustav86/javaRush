package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        System.out.println("Совпадений имени : " + getCountTheSameFirstName(map, "Козленко"));
        System.out.println("Совпадение фамилии : " + getCountTheSameLastName(map, "Козленко"));
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Королев", "Сергей");
        map.put("Козленко", "Роман");
        map.put("Маслов", "Денис");
        map.put("Авдотья", "Петровна");
        map.put("Горыныч", "Владик");
        map.put("Жопа", "Ручковна");
        map.put("Очковый", "Змей");
        map.put("Молодец", "Сын");
        map.put("Мир", "Май");
        map.put("ПриветЭ", "Пока");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (name.equals(pair.getValue()))
                count += 1;
        }

        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (familiya.equals(pair.getKey()))
                count += 1;
        }

        return count;

    }
}
