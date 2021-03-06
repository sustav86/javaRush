package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try
            {
                try
                {
                    String f = rdr.readLine();
                    File file = new File(f);
                    if (!file.exists()) throw new FileNotFoundException(f);
                }
                catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    rdr.close();
                    break;
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
