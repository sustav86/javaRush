package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(name));
        StringBuilder sb = new StringBuilder("");
        String line;
        //-----------------------читаем слова
        while ((line = br.readLine()) != null) {
            sb.append(line + " ");
        }
        br.close();
        //--------------------добавляем в наш метод массив слов, разделенных " "
        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        //----------------Проверка
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder sb = new StringBuilder("");

        List<String> list = new ArrayList<>();
        for (String e : words) {
            list.add(e);
        }
        boolean isIncorrect = true;
        boolean correct;

        while (isIncorrect) {
            Collections.shuffle(list);
            correct = true;
            for (int i = 0; i < list.size(); i++) {
                if (i + 1 != list.size()) {
                    if (!list.get(i).substring(list.get(i).length() - 1).equals(list.get(i + 1).substring(0, 1).toLowerCase())) {
                        correct = false;
                        break;
                    }
                }
            }
            isIncorrect = !correct;
        }

        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(" " + list.get(i));
        }

        return sb;
    }
}
