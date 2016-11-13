package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String value = customer.getCountryName();

            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (value.equals(entry.getValue())) return entry.getKey();
            }

            return null;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            return contact.getName().split(",")[1].trim();
        }

        @Override
        public String getContactLastName()
        {
            return contact.getName().split(",")[0].trim();
        }

        @Override
        public String getDialString()
        {
            StringBuilder phone = new StringBuilder(contact.getPhoneNumber());
            int pos;
            while ((pos = phone.lastIndexOf("(")) > 0 || (pos = phone.lastIndexOf(")")) > 0 || (pos = phone.lastIndexOf("-")) > 0) {
                phone.deleteCharAt(pos);
            }

            return "callto://" + phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}