package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));

        Scanner in = new Scanner(new File(fileNameReader.readLine()));

        String str;
        int sum = 0;
        Pattern myPattern = Pattern.compile("\\bworld\\b");

        while (in.hasNextLine()) {

            str = in.nextLine();

            Matcher matcher = myPattern.matcher(str);

            while (matcher.find()) {
                sum += 1;
            }


//            String[] strArray = str.split("\\p{Punct}");
//
//            for (String world : strArray) {
//
//                if ("world".equals(world.trim())) {
//                    sum += 1;
//                }
//
//                System.out.println(world);
//
//            }

        }

        System.out.println(sum);

        fileNameReader.close();
        in.close();

    }
}
