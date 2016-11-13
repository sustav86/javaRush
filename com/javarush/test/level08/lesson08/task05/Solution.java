package com.javarush.test.level08.lesson08.task05;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            iterator.remove();
            if (copy.containsValue(value))
                removeItemFromMapByValue(map, value);

        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
