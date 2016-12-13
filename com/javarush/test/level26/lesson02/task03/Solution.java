package com.javarush.test.level26.lesson02.task03;

import java.util.*;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
   public static class CustomizedComparator<T> implements Comparator<T> {

       private List<Comparator<T>> comparators = new ArrayList<>();

       public CustomizedComparator(Comparator<T>... comparators) {
           Collections.addAll(this.comparators, comparators);
       }

       @Override
       public int compare(T o1, T o2) {
           for (Comparator item : comparators) {
               int comp = item.compare(o1, o2);
               if (comp != 0) return comp;
           }
           return 0;
       }
   }
}
