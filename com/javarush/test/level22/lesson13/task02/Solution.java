package com.javarush.test.level22.lesson13.task02;

import java.io.*;


/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        if (args.length < 2 || "".equals(args[0]) || "".equals(args[1])) System.exit(-1);
//        String str = new String(win1251TestString.getBytes(), "UTF-8");
//        System.out.println(new String(str.getBytes("Windows-1251")));
        try(InputStream in = new FileInputStream(args[0]); OutputStream out = new FileOutputStream(args[1])) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            String stringFileInput = new String(buffer, "UTF-8");
            out.write(stringFileInput.getBytes("Windows-1251"));
        }catch (IOException ex) {

        }

    }
}
