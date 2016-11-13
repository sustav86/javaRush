package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

//        if (args.length == 0) {
//            System.out.println("Аргументы отсутствуют");
//            return;
//        }
//
//        Map<String, Double> array = new TreeMap<String, Double>();
//
//        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
//
//        String str;
//        String[] arrayStr;
//        String name;
//        Double sum;
//        Double bufferSum;
//
//        while ((str = fileIn.readLine()) != null) {
//            arrayStr = str.split(" ");
//            name = arrayStr[0];
//            sum = Double.parseDouble(arrayStr[1]);
//            bufferSum = 0d;
//            if (array.containsKey(name)) {
//                bufferSum = array.get(name);
//            }
//            array.put(arrayStr[0], sum+bufferSum);
//        }
//
//        for (Map.Entry<String, Double> entry : array.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//
//        fileIn.close();
    }
}
