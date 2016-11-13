package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat formatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {

        if (args.length > 0) {
            String param = args[0];
            if ("-c".equals(param)) createPerson(args);
            else if ("-u".equals(param)) updatePerson(args);
            else if ("-d".equals(param)) deletePerson(args);
            else if ("-i".equals(param)) printPerson(args);
            else System.out.println("Нет нужного параметра");

        }else System.out.println("Нет входных параметров");


    }

    public synchronized static void createPerson(String[] args) throws ParseException
    {
        Person newPerson = null;
        for (int i = 1; i <= args.length-3; i += 3) {
            if ("м".equals(args[i+1])) {
                newPerson = Person.createMale(args[i], format.parse(args[i+2]));
                allPeople.add(newPerson);
            }else if ("ж".equals(args[i+1])) {
                newPerson = Person.createFemale(args[i], format.parse(args[i+2]));
                allPeople.add(newPerson);
            }
            if (!newPerson.equals(null)) System.out.println(allPeople.indexOf(newPerson));

        }

    }

    public synchronized static void updatePerson(String[] args) throws ParseException
    {
        Person getPerson = null;
        for (int i = 1; i <= args.length-4; i += 4) {
            getPerson = allPeople.get(Integer.parseInt(args[i]));
            if (!getPerson.equals(null)) {
                getPerson.setName(args[i+1]);
                getPerson.setSex("м".equals(args[i + 2]) ? Sex.MALE : Sex.FEMALE);
                getPerson.setBirthDay(format.parse(args[i+3]));
            }
        }

    }

    public synchronized static void deletePerson(String[] args) {

        Person getPerson = null;
        for (int i = 1; i < args.length; i++) {
            getPerson = allPeople.get(Integer.parseInt(args[i]));
            if (!getPerson.equals(null)) {
                getPerson.setBirthDay(null);
                getPerson.setName("");
                getPerson.setSex(null);
            }
        }
    }

    public synchronized static void printPerson(String[] args) throws ParseException {

        Person getPerson = null;
        for (int i = 1; i < args.length; i++) {
            getPerson = allPeople.get(Integer.parseInt(args[i]));
            if (!getPerson.equals(null)) {
                System.out.println(getPerson.getName() + " " + (getPerson.getSex() == Sex.MALE ? "м" : "ж") + " " + formatOut.format(getPerson.getBirthDay()));


            }
        }


    }
}
