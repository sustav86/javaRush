package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Аргументы отсутствуют");
            return;
        }

        Map<String, Double> array = new TreeMap<String, Double>();
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));

        String str;
        String[] arrayStr;
        String name;
        Double sum;
        Double buffer;

        while ((str = fileIn.readLine()) != null) {

            arrayStr = str.split(" ");
            name = arrayStr[0];
            sum = Double.parseDouble(arrayStr[1]);
            buffer = 0d;
            if (array.containsKey(name)) {
                buffer = array.get(name);
            }
            array.put(arrayStr[0], sum+buffer);
        }

        List entryList = new ArrayList(array.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Double>>()
        {

            @Override
            public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2)
            {
                return (int) (e2.getValue() - e1.getValue());
            }

        });

        Iterator iterator = entryList.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey());
            break;
        }


        fileIn.close();
    }

}
