package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution
{
    public static void main(String[] args) throws IOException
    {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileWriter fileOutputStream = new FileWriter(reader.readLine());
//        FileInputStream fileInputStream = new FileInputStream(args[0]);
//        FileWriter fileOutputStream = new FileWriter(args[1]);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        String[] str = new String(buffer).split(" ");

        for (int i = 0; i < str.length; i++)
        {
            try
            {
                fileOutputStream.write(new BigDecimal(str[i]).setScale(0, Double.parseDouble(str[i]) < 0 ? RoundingMode.HALF_DOWN : RoundingMode.HALF_UP) + " ");
            }
            catch (NumberFormatException e)
            {

            }

        }

        fileOutputStream.close();
        fileInputStream.close();
        reader.close();


    }
}
