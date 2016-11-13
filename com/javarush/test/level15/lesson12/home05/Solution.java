package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(String str) {

    }

    public Solution(Integer num) {

    }

    public Solution(Double dub) {

    }

    private Solution(int num) {

    }

    private Solution(double dub) {

    }

    private Solution(char ch) {

    }

    Solution(Character ch) {

    }

    Solution(Character ch, String str) {

    }

    Solution(Character ch, int num) {

    }

    protected Solution(String dtr, Integer num) {

    }

    protected Solution(String dtr, Integer num, Double db) {

    }

    protected Solution(String dtr, Integer num, Double db, Character ch) {

    }

}

