package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

//        Map<Integer, Integer> unsortedMap = new TreeMap<Integer, Integer>();
            Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });



        int nextByte = 0;
        int keyByte = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0) {
            nextByte = inputStream.read();
            if (sortedMap.containsKey(nextByte)) {
                keyByte = sortedMap.get(nextByte);
                sortedMap.put(nextByte, ++keyByte);
            } else {
                sortedMap.put(nextByte, 1);
            }

        }

        inputStream.close();
        reader.close();

        sortedMap.putAll(sortedMap);

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("/*********/");

        List entryList = new ArrayList(sortedMap.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue()-e1.getValue();
            }

        });

        Iterator entry = entryList.iterator();
        while (entry.hasNext()) {
            Map.Entry mentry = (Map.Entry)entry.next();
            System.out.println(mentry.getKey() + " " + mentry.getValue());
        }

    }
}
