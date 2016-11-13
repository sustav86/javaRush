package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {

    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {

        Object myObject = new Object();
        myObject.string1 = new String();
        myObject.string2 = new String();

        //Serializing the singleton instance
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.tmp"));
        oos.writeObject(myObject);
        oos.close();

        //Recreating the instance by reading the serialized object data store
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.tmp"));
        Object myObjectLoad = (Object) ois.readObject();
        ois.close();

        myObjectLoad.string1.print();
        myObjectLoad.string2.print();

    }

    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
