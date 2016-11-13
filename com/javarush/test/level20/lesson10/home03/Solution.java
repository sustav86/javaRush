package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс SearchMaximalElement не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

    static final long serialVersionUID = 1L;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution slo = new Solution();
        Solution.B b1 = slo.new B("B");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("201003"));
        oos.writeObject(b1);
        System.out.println(b1.name);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("201003"));
        Solution.B b2 = (Solution.B) ois.readObject();
        System.out.println(b2.name);
        ois.close();

    }

    public static class A {
        protected String name = "SearchMaximalElement";

        public A() {

        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String) in.readObject();
        }
    }
}
