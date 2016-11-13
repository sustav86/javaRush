package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    private static int maxID;

    public static void main(String[] args) throws Exception {

        if (args.length < 4 || !"-c".equals(args[0])) return;

        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBilder = new StringBuilder();

        String fileName = readerFileName.readLine();

        readeringFile(fileName, stringBilder);

        PrintWriter fileOut = new PrintWriter(fileName);

        stringBilder.append(appendSpace(Integer.toString(++maxID), 8)+appendSpace(args[1], 30)+appendSpace(args[2], 8)+appendSpace(args[3], 4));

        fileOut.write(stringBilder.toString());

        readerFileName.close();
        fileOut.close();

    }

    public static void readeringFile(String fileName, StringBuilder stringBuilder) throws IOException
    {
        BufferedReader fileReader = null;

        try
        {
            fileReader = new BufferedReader(new FileReader(fileName));
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            fileReader.close();
            return;
        }

        String s;
        String id;
        while ((s = fileReader.readLine()) != null) {
            id = getNum(s.substring(0, 8));
            if (Integer.parseInt(id) > maxID) maxID = Integer.parseInt(id);
            stringBuilder.append(s);
            stringBuilder.append(System.getProperty("line.separator"));
        }

        fileReader.close();

    }

    public static String getNum(String stringId) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < stringId.length(); i++) {
            if (stringId.charAt(i) >= 48 && stringId.charAt(i) <= 57 ) stringBuilder.append(stringId.charAt(i));

        }

        return stringBuilder.toString();

    }

    public static String appendSpace(String stringSpace, int lenSymbol) {

        StringBuilder stringBuilder = new StringBuilder(stringSpace);

        while(stringBuilder.length() < lenSymbol) {
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();

    }
}
