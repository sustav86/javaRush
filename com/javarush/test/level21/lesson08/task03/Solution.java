package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A implements Cloneable {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }
    }

    public static void main(String[] args) {
        A a1 = new A(1, 2);
        A clone = null;
        try {
            clone = (A)a1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("a1 = " + a1.i + " " + a1.j);
        System.out.println("clone = " + clone.i + " " + clone.j);

        C c1 = new C(1, 2, "df");
        C cloneC = null;
        try {
            cloneC = (C)c1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("c1 = " + c1.getI() + " " + c1.getJ());
        System.out.println("cloneC = " + cloneC.getI() + " " + clone.getJ());

//        B b1 = new B(1, 2, "df");
//        B cloneB = null;
//        try {
//            cloneB = b1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("b1 = " + b1.getI() + " " + b1.getJ());
//        System.out.println("cloneB = " + cloneB.getI() + " " + cloneB.getJ());
    }
}
