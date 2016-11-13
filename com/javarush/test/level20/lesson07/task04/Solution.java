package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Externalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        System.out.println(new Solution(4));

        Solution savedObject = new Solution(88);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("solo.tmp"));
        savedObject.writeExternal(oos);
        oos.close();

        System.out.println(savedObject.toString());

        Solution loadedObject = new Solution();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("solo.tmp"));
        loadedObject.readExternal(ois);
        ois.close();

        System.out.println(loadedObject.toString());

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution() {

    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
//        out.writeInt(temperature);
        out.writeObject(string);
//        out.writeObject(currentDate);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {

//        temperature = in.readInt();
        string = (String)in.readObject();
//        SimpleDateFormat format = new SimpleDateFormat(pattern);
//        currentDate = new Date((String)in.readObject());

    }
}
