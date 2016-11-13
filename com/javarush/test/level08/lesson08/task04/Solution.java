package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Вася", new Date("DECEMBER 1 1980"));
        map.put("Катя", new Date("JUNE 1 1980"));
        map.put("Машка", new Date("JUNE 1 1980"));
        map.put("Олька", new Date("JUNE 1 1980"));
        map.put("Светка", new Date("JUNE 1 1980"));
        map.put("Маруся", new Date("JUNE 1 1980"));
        map.put("Женя", new Date("JUNE 1 1980"));
        map.put("Карина", new Date("JUNE 1 1980"));
        map.put("Урка", new Date("JUNE 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> newMap = new HashMap<String, Date>();
        newMap.putAll(map);

        Iterator<Map.Entry<String, Date>> iterator = newMap.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> ls = iterator.next();
            if (ls.getValue().getMonth() > 4 && ls.getValue().getMonth() < 8)
                map.remove(ls.getKey());
        }

    }
}
