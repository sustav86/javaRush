package com.javarush.test.level25.lesson11.task02;

/* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечьте переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public synchronized void run() {
            Thread.yield();
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new YieldRunnable(i).run();
        }
    }
}
