package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.3, "sdf");
        labels.put(1.4, "sdf");
        labels.put(1.5, "sdf");
        labels.put(1.6, "sdf");
        labels.put(1.7, "sdf");
    }

    public static void main(String[] args) {

        System.out.println(labels);
    }
}
