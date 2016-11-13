package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

//    static
//    {
//        words.add("SearchMaximalElement");
//        words.add("B");
//        words.add("V");
//    }

    public static void main(String[] args) throws IOException
    {

        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileIn = new BufferedReader(new FileReader(readerFileName.readLine()));

        String str;

        while ((str = fileIn.readLine()) != null)
        {

            int sum = 0;

            for (String strWords : words)
            {

                Pattern myPattern = Pattern.compile("\\b"+strWords+"\\b");

                Matcher matcher = myPattern.matcher(str);


                while (matcher.find())
                {

                    sum += 1;

                }

            }

            if (sum == 2) System.out.println(str);

        }

        fileIn.close();
        readerFileName.close();

    }
}
