package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution
{


    public static void main(String[] args) throws IOException
    {

        String fileName;
        Map<Integer, String> fileHashMap = new HashMap<Integer, String>();
        StringBuilder stringBilder = new StringBuilder();

        BufferedReader readerFile = new BufferedReader(new InputStreamReader(System.in));

        if ((fileName = readerFile.readLine()).equals(""))
        {
            print("Пустое имя файла");
            return;
        }

        File file = new File(fileName);

        if (!file.exists())
        {
            print("Файла не существует");
            return;
        }

        collectionBD(file, fileHashMap);

        if ("-u".equals(args[0]))
        {

            updateBD(fileHashMap, args);

        } else if ("-d".equals(args[0]))
        {

            deleteBD(fileHashMap, args);

        }

        PrintWriter fileOut = new PrintWriter(file);

        for (Map.Entry<Integer, String> entry : fileHashMap.entrySet())
        {
            stringBilder.append(getSpace(entry.getKey().toString(), 8) + entry.getValue());
            stringBilder.append(System.getProperty("line.separator"));

        }

        fileOut.write(stringBilder.toString());

        fileOut.close();
        readerFile.close();

    }

    public static void collectionBD(File file, Map<Integer, String> fileHashMap) throws IOException
    {

        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        String str;
        String id;
        while ((str = fileReader.readLine()) != null)
        {
            id = getNum(str.substring(0, 8));
            fileHashMap.put(Integer.parseInt(id), str.substring(8, str.length()));

        }
    }

    public static String getNum(String stringId)
    {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < stringId.length(); i++)
        {
            if (stringId.charAt(i) >= 48 && stringId.charAt(i) <= 57) stringBuilder.append(stringId.charAt(i));

        }

        return stringBuilder.toString();

    }

    public static void updateBD(Map<Integer, String> fileHashMap, String[] args)
    {


        if (fileHashMap.containsKey(Integer.parseInt(args[1])))
        {

            fileHashMap.put(Integer.parseInt(args[1]), getSpace(args[2], 30) + getSpace(args[3], 8) + getSpace(args[4], 4));
        }

    }

    public static void deleteBD(Map<Integer, String> fileHashMap, String[] args)
    {


        if (fileHashMap.containsKey(Integer.parseInt(args[1])))
        {

            fileHashMap.remove(Integer.parseInt(args[1]));
        }

    }

    public static void print(String message)
    {
        System.out.println(message);
    }

    public static String getSpace(String str, int num)
    {

        while (str.length() < num)
        {
            str += " ";
        }

        return str;

    }
}
