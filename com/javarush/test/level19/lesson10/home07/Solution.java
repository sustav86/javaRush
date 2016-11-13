package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        if (args.length < 2)
        {
            System.out.println("Нет параметров");
            return;
        }

        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        FileWriter fileOut = new FileWriter(args[1]);

        String str;
        StringBuffer strOut = new StringBuffer();
        Boolean entry = true;
        while ((str = fileIn.readLine()) != null)
        {

            String[] arrayStr = str.split(" ");

            for (String strStep : arrayStr)
            {
                if (strStep.length() > 6)
                {
                    if (!entry) strOut.append(",");
                    else entry = false;

                    strOut.append(strStep);


                }
            }

//            strOut.append(System.lineSeparator());

        }

        fileOut.write(strOut.toString());

        fileOut.close();
        fileIn.close();

    }
}
