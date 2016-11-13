package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Нет параметров");
            return;
        }

        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        String str;

        while ((str = fileIn.readLine()) != null) {

            String[] arrayStr = str.split(" ");

            Pattern myPattern = Pattern.compile("[0-9]");

            for (String string : arrayStr) {

                Matcher matcher = myPattern.matcher(string);

                while (matcher.find()) {

                    fileOutputStream.write((string+" ").getBytes());
                    break;

                }

            }


        }

        fileOutputStream.close();
        fileIn.close();


    }
}
