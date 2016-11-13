package com.javarush.test.level20.lesson10.home01;

import java.io.Serializable;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
public class Solution {

    public class A implements Serializable {
        String name = "SearchMaximalElement";

//        public SearchMaximalElement() {
//
//        }

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

//        public B()
//        {
//            super();
//        }

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

//        public C() {
//            super();
//        }

        public C(String name) {
            super(name);
            this.name = name;
        }
    }
}
