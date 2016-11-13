package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat formatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException
    {


        if (args.length > 0)
        {
            String key = args[0];
            if ("-c".equals(key)) createPerson(args);
            else if ("-u".equals(key)) updatePerson(args);
            else if ("-d".equals(key)) deletePerson(args);
            else if ("-i".equals(key)) printPerson(args);
            else return;
        }


    }

    public synchronized static void createPerson(String[] args) throws ParseException
    {
        if ("м".equals(args[2])) {
            Person newMale = (Person.createMale(args[1], format.parse(args[3])));
            allPeople.add(newMale);
            System.out.println(allPeople.indexOf(newMale));
        }
        else if ("ж".equals(args[2])) {
            Person newFemale = Person.createFemale(args[1], format.parse(args[3]));
            allPeople.add(newFemale);
            System.out.println(allPeople.indexOf(newFemale));
        }
        else return;

    }

    public synchronized static void updatePerson(String[] args) throws ParseException
    {
        Person personBuffer = allPeople.get(Integer.parseInt(args[1]));
        personBuffer.setName(args[2]);

        personBuffer.setBirthDay(format.parse(args[4]));

        if ("м".equals(args[3])) personBuffer.setSex(Sex.MALE);
        else if ("ж".equals(args[3])) personBuffer.setSex(Sex.FEMALE);
    }

    public synchronized static void deletePerson(String[] args)
    {

        Person deadPerson = allPeople.get(Integer.parseInt(args[1]));
        deadPerson.setBirthDay(null);
        deadPerson.setName("");
        deadPerson.setSex(null);

    }

    public synchronized static void printPerson(String[] args) throws ParseException
    {

        Person person = allPeople.get(Integer.parseInt(args[1]));

        System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + formatOut.format(person.getBirthDay()));

    }

}
