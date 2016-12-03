package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!(fileName = reader.readLine()).equals("exit"))
        {

            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            try
            {
                readThread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        reader.close();



    }

    public static class ReadThread extends Thread {

        private String fileName;
        private Map<Integer, Integer> treeArray = new TreeMap<>();
        private Integer nextByte;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;

        }


        @Override
        @SuppressWarnings("unchecked")
        public void run()
        {

            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0)
                {
                    nextByte = fileInputStream.read();
                    if (treeArray.containsKey(nextByte))
                    {
                        int value = treeArray.get(nextByte);
                        treeArray.put(nextByte, ++value);
                    } else
                    {
                        treeArray.put(nextByte, 1);

                    }
                }

//                fileInputStream.close();
//
//                Integer maxValue = Integer.MIN_VALUE;
//                Integer lastKeyWithMaxValue = 0;
//                for (Map.Entry<Integer, Integer> entry : treeArray.entrySet()) {
//                    if (entry.getValue() >= maxValue) {
//                        maxValue = entry.getValue();
//                        lastKeyWithMaxValue = entry.getKey();
//                    }
//                }

                List entryList = new ArrayList(treeArray.entrySet());


                Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {

                    @Override
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        return e2.getValue() - e1.getValue();
                    }

                });

                Map.Entry maxByteEntry = (Map.Entry) entryList.get(0);

                resultMap.put(fileName, (Integer) maxByteEntry.getKey());


            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
