package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;
    public static final long serialVersionUID = 170501993;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution solutionMain = new Solution(5);
        FileOutputStream fos = new FileOutputStream("l20l07t05.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solutionMain);
        fos.close();
        oos.close();

        FileInputStream fis = new FileInputStream("l20l07t05.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution solution = (Solution)ois.readObject();
//        solution.runner = solutionMain.runner;
//        solution.speed = 200;
        fis.close();
        ois.close();

    }

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        while (!runner.isInterrupted()) {
            System.out.println(speed);
            speed++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.runner = new Thread(this);
        this.runner.start();
    }
}
