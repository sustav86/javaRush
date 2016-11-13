package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    private transient FileOutputStream stream;
    private static final long serialVersionUID = 1L;
    private String fileName;


    public static void main(String[] args) throws Exception {

        String filename = "l20l10h7.txt";
        Solution solution = new Solution(filename);
        solution.writeObject("aaa");
        solution.writeObject("ccc");
        ObjectOutputStream oos1 = new ObjectOutputStream(solution.stream);
        oos1.writeObject(solution);
//        solution.writeObject(oos1);
//        solution.stream.close();
//        oos1.close();
        Solution loadedSolution = new Solution();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("l20l10h7_2.txt"));
        loadedSolution.readObject(ois);
        ObjectOutputStream oos2 = new ObjectOutputStream(loadedSolution.stream);
        loadedSolution.writeObject("bbb");
        loadedSolution.stream.close();
        oos2.close();

        /*
        My test
         */
//        Solution solution = new Solution("l20l10h7.txt");
//        solution.writeObject("sdfdsfsdf");
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("l20l10h7_2.txt"));
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("l20l10h7_2.txt"));
//
//        outputStream.writeObject(solution);
//        outputStream.close();
//
//        Solution solution1 = new Solution("l20l10h7_2.txt");
//        solution1.readObject(inputStream);
//        solution.readObject(inputStream);
//        solution1.writeObject("22222222");
//        solution1.readObject(inputStream);
//        solution1.writeObject(inputStream);


    }

    public Solution()
    {
    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
