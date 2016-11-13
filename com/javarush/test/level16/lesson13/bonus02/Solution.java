package com.javarush.test.level16.lesson13.bonus02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
//        threads.add(new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(400);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName());
//            }
//        }));
//        threads.add(new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    System.out.println("InterruptedException");
//                }
//
//            }
//
//        }));
//        threads.add(new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(500);
//                    System.out.println("Ура");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }));
//        threads.add(new ThreadFour());
//        threads.add(new Thread(() -> {
//            Scanner scanner = new Scanner(System.in);
//            int sum = 0;
//            String line;
//            do {
//                line = scanner.nextLine();
//                try {
//                    sum += Integer.parseInt(line);
//                }catch (NumberFormatException e) {
//
//                }
//            }while (!"N".equals(line));
//            System.out.println(sum);
//        }));
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static void main(String[] args) {
//        threads.forEach(Thread::start);
    }

    static public class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {

            }

        }

    }

    static public class ThreadTwo extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }

        }

    }

    static public class ThreadThree extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                    System.out.println("Ура");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static public class ThreadFour extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {

            }

        }

        @Override
        public void showWarning() {
            interrupt();

            try
            {
                join();
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    static public class ThreadFive extends Thread {
        @Override
        public void run() {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                int sum = 0;
                String line;
                do {
                    line = scanner.nextLine();
                    try {
                        sum += Integer.parseInt(line);
                    }catch (NumberFormatException e) {

                    }
                }while (!"N".equals(line));
                System.out.println(sum);
            }

        }

    }


}


