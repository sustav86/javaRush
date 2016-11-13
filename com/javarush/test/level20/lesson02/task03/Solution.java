package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties pr = new Properties();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
//        OutputStream out = new FileOutputStream("fileOut.properties");
        load(in);
//        save(out);

        reader.close();
        in.close();
//        out.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for(Map.Entry<String, String> entry : properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            pr.setProperty(key, value);
        }
        pr.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        pr.load(inputStream);
        Enumeration<?> enumeration = pr.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String)enumeration.nextElement();
            String value = pr.getProperty(key);
            properties.put(key, value);
        }

    }

    public static void main(String[] args) throws Exception
    {
        new Solution().fillInPropertiesMap();

    }
}
