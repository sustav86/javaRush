package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        FileWriter writer = new FileWriter(br.readLine());

        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBufferResult = new StringBuffer();
        Pattern myPattern = Pattern.compile("\\p{Punct}");

        String str;

        while ((str = reader.readLine()) != null) {

            stringBuffer.setLength(0);
            stringBuffer.append(str);
            Matcher matcher = myPattern.matcher(str);
            int i = 0;
            while (matcher.find()) {
//                System.out.println(str.substring(matcher.start(), matcher.end()));
                stringBuffer.deleteCharAt(matcher.end()-1-i);
//                stringBuffer.replace(matcher.start(), matcher.end(), " ");
                i++;
            }

            stringBufferResult.append(stringBuffer.toString());
//            stringBuffer.append(System.lineSeparator());
        }

        writer.write(stringBufferResult.toString());

        writer.close();
        reader.close();
        br.close();


//        FileReader reader = new FileReader(br.readLine());
//        FileWriter writer = new FileWriter(br.readLine());
//
//        while (reader.ready())
//        {
//            char c = (char) reader.read();
//            if (!Pattern.matches("\\p{Punct}+", String.valueOf(c)))
//            {
//                writer.write(c);
//            }
//        }
//        reader.close();
//        writer.close();

    }


//        byte[] buffer = null;
//        List<Byte> array = new ArrayList<Byte>();
//        String str;
//
//        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
//
////        FileInputStream fileInputStream = new FileInputStream(readerFileName.readLine());
//        FileOutputStream fileOutputStream = new FileOutputStream(readerFileName.readLine());
//
//        BufferedReader reader = new BufferedReader(new FileReader(readerFileName.readLine()));
//
//        while ((str = reader.readLine()) != null) {
//            fileOutputStream.write(str.replaceAll("[\\p{Punct}]", "").getBytes());
//        }


//        if (fileInputStream.available() > 0)
//        {
//
//            buffer = new byte[fileInputStream.available()];
//
//            fileInputStream.read(buffer);
//        }

    ///////////
//        array.add((byte)145);
//        array.add((byte)146);
//
//        array.add((byte)91);
//        array.add((byte)93);
//
//        array.add((byte)40);
//        array.add((byte)41);
//
//        array.add((byte)123);
//        array.add((byte)125);
//
//        array.add((byte)139);
//        array.add((byte)155);
//
//        array.add((byte)58);
//
//        array.add((byte)44);
//
//        array.add((byte)150);
//        array.add((byte)151);
//        array.add((byte)45); //
//        array.add((byte)95); //
//
//        array.add((byte)133);
//
//        array.add((byte)33);
//        array.add((byte)46);
//        array.add((byte)45);
//        array.add((byte)63);
//
//        array.add((byte)39);
//        array.add((byte)34);
//        array.add((byte)130);
//        array.add((byte)132);
//
//        array.add((byte)147);
//        array.add((byte)148);
//
//        array.add((byte)171);
//        array.add((byte)187);
//
//        array.add((byte)59);
//        array.add((byte)32);
//
//        array.add((byte)13);
//        array.add((byte)10);
//        array.add((byte)9);
//
//
//        for (int i = 0; i < buffer.length; i++)
//        {
//
//            if (array.contains(buffer[i])) {
//                buffer[i] = 0;
//            }
//
//        }

//        fileOutputStream.write(buffer);

//        fileOutputStream.close();
////        fileInputStream.close();
//        reader.close();
//        readerFileName.close();


}

