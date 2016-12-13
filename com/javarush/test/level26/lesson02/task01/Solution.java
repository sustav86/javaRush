package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
//        int sum = 0;
//        int count = 0;
//        int delta = 0;
        int median = 0;
        //implement logic here
//        for (int i = 0; i < array.length; i++) {
//            sum += array[i];
//            count++;
//            delta = sum / count / count;
//            if (array[i] < median) {
//                median -= delta;
//            }else {
//                median += delta;
//            }
//        }
        Collections.sort(Arrays.asList(array));

        if (array.length % 2 == 0) median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else median = array[Math.abs(array.length / 2)];
        System.out.println(median);
        final int med = median;

        List<Integer> buffer = Arrays.asList(array);

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - med) == Math.abs(o2 - med)) return o1 - o2;
                return Math.abs(o1 - med) - Math.abs(o2 - med);
            }
        };

        Collections.sort(buffer, comp);

//        System.out.println("Median = " + median);

        return (Integer[])buffer.toArray();
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[18];
        Random random = new Random();
        for (int i = 0; i < 18; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        array = new Integer[]{5, 8, 15, 17};
        array = sort(array);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
