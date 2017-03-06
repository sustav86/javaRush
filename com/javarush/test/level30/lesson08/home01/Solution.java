package com.javarush.test.level30.lesson08.home01;

/* Swap по-новому
В классе Pair реализуйте метод swap, который должен для x, y менять местами их значения.
Можно использовать только операции 1)исключающее или, 2) присваивание
Не оставляйте комментарии, не меняйте остальной код
*/
public class Solution {
    public static void main(String[] args) {
        Pair pair = new Pair(4, 5);
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);

        String a = new String("hello");
        String b = new String(a);
        String c = a;
        char[] d = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(a == "hello");
        System.out.println(a.equals(d));
        System.out.println(a.equals(b));
        System.out.println(a == c);
        System.out.println(a == b);

        int result = 12 + 2 * 5 % 3 - 15 / 4;
        String x = 12 - 6 + "Hello" + 7 + 5;

        System.out.println(result + " - " + x);
    }
}
