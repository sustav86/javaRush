package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();


        int nextByte = 0;
        int keyByte = 0;
        int maxByte = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());

        while (inputStream.available() > 0)
        {
            nextByte = inputStream.read();
            if (sortedMap.containsKey(nextByte))
            {
                keyByte = sortedMap.get(nextByte);
                sortedMap.put(nextByte, ++keyByte);
            } else
            {
                sortedMap.put(nextByte, 1);
            }

        }

        inputStream.close();
        reader.close();

        List entryList = new ArrayList(sortedMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>()
        {

            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2)
            {
                return e1.getValue() - e2.getValue();
            }

        });

//        Iterator entry = entryList.iterator();
//        Map.Entry maxByteEntry = (Map.Entry) entryList.get(0);
//        maxByte = (int) maxByteEntry.getValue();
//        while (entry.hasNext()) {
//            Map.Entry mentry = (Map.Entry)entry.next();
//            if ((int)mentry.getValue() <= maxByte) System.out.println(mentry.getKey() + " ");
//        }
    }
}
