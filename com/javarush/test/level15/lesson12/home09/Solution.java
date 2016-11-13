package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        List<String> paramsList = new ArrayList<>();
        List<String> captionList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        if (!url.equals(""))
        {
            String[] firstStep = url.split("\\?");
            if (firstStep.length > 1)
            {
                String[] params = firstStep[1].split("&");
                for (String param : params)
                {
                    if (param.contains("="))
                    {
                        String p = param.substring(0, param.indexOf("="));
                        paramsList.add(p);
                        if ("obj".equals(p))
                        {
                            String c = param.substring(param.indexOf("=")+1, param.length());
                            captionList.add(c);

                        }

                    }else {
                        paramsList.add(param);
                    }

                }
            }

        }
        for (String ss : paramsList) {
            System.out.print(ss + " ");
        }
        System.out.println();
        for (String ss : captionList) {

            if (ss.matches("[-+]?\\d+") || ss.contains(".")) {
                alert(Double.parseDouble(ss));
            }else {
                alert(ss);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
