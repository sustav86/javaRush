package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileIn = new BufferedReader(new FileReader(readerFileName.readLine()));
        StringBuffer strOut = new StringBuffer();

        String str;

        while ((str = fileIn.readLine()) != null) {
            strOut.append(str);
            strOut.reverse();
//            strOut.append(System.lineSeparator());
            System.out.println(strOut);
            strOut.setLength(0);
        }

//        System.out.println(strOut);

        fileIn.close();
        readerFileName.close();
    }
}
