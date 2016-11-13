package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(new FileReader(reader.readLine()));

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine().split(" "));
        }

        for (String[] st : list) {
            if (args[0].equals(st[0])) {
                for (int i = 0; i < st.length; i++) {
                    System.out.print(st[i] + " ");
                }
                break;
            }
        }

//        for (int i = 0; i < st.length; i++) {
//            System.out.print(st[i] + " ");
//        }
//            System.out.println();


//        BufferedReader file = new BufferedReader(new FileReader(args[0]));

//        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

//        Stream<String> str = file.lines();

//        str.forEach(s -> System.out.println("forEach: " + s));
//        String[] str = (String[]) file.lines().toArray();
//        for (String st : str) {
//            System.out.println(st);
//
//        }
//        int i = 0;

//        System.out.println(str.count());


    scanner.close();
        reader.close();

    }
}
