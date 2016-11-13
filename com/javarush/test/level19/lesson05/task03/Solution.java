package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        String str;
        String[] arrayStr;

        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader readFile = new BufferedReader(new FileReader(readerFileName.readLine()));
        FileOutputStream fileOutputStream = new FileOutputStream(readerFileName.readLine());


        while ((str = readFile.readLine()) != null)
        {

            arrayStr = str.split(" ");

            Boolean isInteger = false;
            String bufferSS = "";

            for (String ss : arrayStr)
            {

                if (isInteger)
                {

                    fileOutputStream.write(bufferSS.getBytes());
                    fileOutputStream.write(32);
                    isInteger = false;
                    bufferSS = ss;

                } else
                {
                    bufferSS = ss;

                }


                for (int i = 0; i < ss.length(); i++)
                {
                    if (ss.charAt(i) >= 48 && ss.charAt(i) <= 65) {
                        isInteger = true;
                    }else {
                        isInteger = false;
                        break;
                    }

                }

            }

            if (isInteger && bufferSS.length() > 0) {

                fileOutputStream.write(bufferSS.getBytes());
                fileOutputStream.write(32);
                isInteger = false;
                bufferSS = "";

            }

        }

        readerFileName.close();
        readFile.close();
        fileOutputStream.close();


//        while ((str = readFile.readLine()) != null) {
//
//            arrayStr = str.split(" ");
//
//            for (String ss : arrayStr) {
//
//                try
//                {
//                    Integer.parseInt(ss);
//                    fileOutputStream.write(ss.getBytes());
//                    fileOutputStream.write(32);
//
//                }catch (NumberFormatException ex) {
//                    continue;
//                }
//
//            }
//
//        }
//
//        readerFileName.close();
//        readFile.close();
//        fileOutputStream.close();
    }
}
