package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {

        Apartment myApartament = new Apartment("Los-Angeles", 12345);
        System.out.println(myApartament.serialVersionUID);
        System.out.println("out");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("apartament.tmp"));
        myApartament.writeExternal(oos);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("apartament.tmp"));
        Apartment myApartamentNew = new Apartment();
        myApartamentNew.readExternal(ois);
        System.out.println(myApartamentNew.address);
        System.out.println(myApartamentNew.year);
        System.out.println(myApartamentNew.serialVersionUID);
    }

    public static class Apartment implements Externalizable {

        private String address;
        private int year;
        private static final long serialVersionUID = 1L;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(address);
            out.writeInt(year);
//            out.close();

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            address = (String) in.readObject();
            year = in.readInt();
//            in.close();

        }
    }
}
