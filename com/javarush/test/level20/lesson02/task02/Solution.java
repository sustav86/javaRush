package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Petrov");
            user.setMale(true);
            user.setBirthDate(new Date(201401013434l));
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isUser = users != null ? "yes" : "no";
            writer.println(isUser);
            if (isUser.equals("yes"))
            {
                int quantity = users.size();
                writer.println(quantity);
                for (User strUser : users)
                {
                    writer.println(strUser.getFirstName());
                    writer.println(strUser.getLastName());
                    writer.println(strUser.isMale());
                    writer.println(dateFormat.format(strUser.getBirthDate()));
                    writer.println(strUser.getCountry());

                }
            }
            writer.flush();

        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUser = reader.readLine();
            if (isUser.equals("yes"))
            {
                int quantity = Integer.parseInt(reader.readLine());
                if (quantity > 0)
                {
                    for (int i = 0; i < quantity; i++)
                    {
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setMale(reader.readLine().equals("true") ? true : false);
                        user.setBirthDate(dateFormat.parse(reader.readLine()));
                        String country = reader.readLine();
                        switch (country)
                        {
                            case "UKRAINE":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "RUSSIA":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            default:
                                user.setCountry(User.Country.OTHER);
                                break;
                        }
                        users.add(user);
                    }


                }
            }
        }
    }
}

