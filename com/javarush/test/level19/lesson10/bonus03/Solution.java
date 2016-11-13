package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) System.exit(-1);
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (java.io.IOException e) {
//            e.printStackTrace();
            System.exit(0);
        }finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Stack<Integer> stack = new Stack<>();
        String attribute = args[0];
        int indexOfAttribute = stringBuilder.indexOf(attribute);
        int startIndex;
        while (indexOfAttribute != -1) {
            if (indexOfAttribute - 1 >= 0 && stringBuilder.charAt(indexOfAttribute - 1) == '<') {
                stack.push(indexOfAttribute);
            } else if (indexOfAttribute - 2 >= 0 && stringBuilder.charAt(indexOfAttribute - 2) == '<' && stringBuilder.charAt(indexOfAttribute - 1) == '/') {
                if (!stack.empty()) {
                    startIndex = stack.pop();
                    if (stack.empty()) {
                        System.out.println(stringBuilder.substring(startIndex - 1, indexOfAttribute + attribute.length() + 1));
                    }
                }
            }
            indexOfAttribute = stringBuilder.indexOf(attribute, ++indexOfAttribute);
        }
    }
}
