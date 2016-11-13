package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateString = reader.readLine();
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        Date date = formatDate.parse(dateString);
        SimpleDateFormat newFormatDate = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        System.out.println(newFormatDate.format(date));

        Calendar c = Calendar.getInstance();

        String allFormats = "'Era designator:' G\n"
                + "'Year:' y\n"
                + "'Month in year:' M\n"
                + "'Week in year:' w\n"
                + "'Week in month:' W\n"
                + "'Day in year:' D\n"
                + "'Day in month:' d\n"
                + "'Day of week in month:' F\n"
                + "'Day in week:' E\n"
                + "'Am/pm marker:' a\n"
                + "'Hour in day (0-23):' H\n"
                + "'Hour in day (1-24):' k\n"
                + "'Hour in am/pm (0-11):' K\n"
                + "'Hour in am/pm (1-12):' h\n"
                + "'Minute in hour:' m\n"
                + "'Second in minute:' s\n"
                + "'Millisecond:' S\n"
                + "'General time zone:' z\n"
                + "'RFC 822 time zone:' Z\n";

        SimpleDateFormat all = new SimpleDateFormat(allFormats);

        System.out.println(all.format(c.getTime()));
    }
}
