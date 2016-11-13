package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{

        int nextByte = 0;
        int value = 0;

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        Map<Integer, Integer> array = new TreeMap<Integer, Integer>();

        while (fileInputStream.available() > 0) {
            nextByte = fileInputStream.read();

            if (array.containsKey(nextByte)) {
                value = array.get(nextByte);
                array.put(nextByte, ++value);
            }else array.put(nextByte, 1);

        }

        for (Map.Entry<Integer, Integer> entry : array.entrySet()) {
            System.out.println((char)entry.getKey().byteValue()+" "+entry.getValue());
        }

        fileInputStream.close();


    }
}
