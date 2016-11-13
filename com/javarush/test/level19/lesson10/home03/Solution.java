package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {

        if (args.length == 0)
        {
            System.out.println("Аргументы отсутствуют");
            return;
        }

        String str;
        String name;
        String birthdayString;
        String[] arrayBirthday;
        DateFormat formatter = null;
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));

        while ((str = fileIn.readLine()) != null)
        {

            name = regExecute("\\D{1,100}", str).trim();
            birthdayString = regExecute("\\d{1,100}", str).trim();
            arrayBirthday = birthdayString.split(" ");

            int year = Integer.parseInt(arrayBirthday[2]);
            int month = Integer.parseInt(arrayBirthday[1])-1;
            int day = Integer.parseInt(arrayBirthday[0]);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, day);

            formatter = new SimpleDateFormat("dd mm yyyy");

            PEOPLE.add(new Person(name, cal.getTime()));

        }

        for (Person son : PEOPLE) {

            System.out.println(son.getName() + " " + formatter.format(son.getBirthday()));

        }

        fileIn.close();
    }

    public static String regExecute(String regEx, String str)
    {
        String buffer = "";

        Pattern myPattern = Pattern.compile(regEx);

        Matcher matcher = myPattern.matcher(str);

        while (matcher.find()) {

            buffer += str.substring(matcher.start(), matcher.end()) + " ";

        }

        return buffer;
    }

}
