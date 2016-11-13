package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file = new BufferedReader(new FileReader(readFileName.readLine()));
        BufferedReader fileUpdate = new BufferedReader(new FileReader(readFileName.readLine()));

        List<String> linesFile = new ArrayList<String>();
        List<String> linesFileUpdate = new ArrayList<String>();

        prReadLines(file, linesFile);
        prReadLines(fileUpdate, linesFileUpdate);


        for (int i = 0; i < linesFileUpdate.size(); i++)
        {
            if (linesFile.contains(linesFileUpdate.get(i)))
            {
                lines.add(new LineItem(Type.SAME, linesFileUpdate.get(i)));
                linesFile.remove(linesFileUpdate.get(i));
            } else if (!linesFile.contains(linesFileUpdate.get(i)))
            {
                lines.add(new LineItem(Type.ADDED, linesFileUpdate.get(i)));
            }
        }

//        if (linesFile.size() > 0) {
//            for (String line : linesFile) {
//                lines.add(new LineItem(Type.REMOVED, line));
//
//            }
//        }

        if (linesFile.size() > 0) {
            for (String line : linesFile) {
                for (int i = 0; i < lines.size()-1;i++) {
                    try {
                        if (lines.get(i-1).type == Type.SAME && lines.get(i).type == Type.SAME) {
                            lines.add(i, new LineItem(Type.REMOVED, line));
                            break;
                        }

                    }catch (Exception ex) {

                    }
                }


            }
        }

//        for (int i = 0; i < lines.size()-1; i++) {
//            if (lines.get(i).type == Type.REMOVED) {
//
//            }
//        }

//        lines.add(2, new LineItem(Type.ADDED, "dfvdfvfvdfv"));
        for (LineItem ss : lines) {

            System.out.println(ss);

        }


        fileUpdate.close();
        file.close();
        readFileName.close();



    }

    public static void prReadLines(BufferedReader file, List<String> linesFile) throws IOException
    {

        String str;

        while ((str = file.readLine()) != null)
        {

            linesFile.add(str.trim());

        }

    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
