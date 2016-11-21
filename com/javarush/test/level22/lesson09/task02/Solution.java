package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        if (params == null || params.size() == 0) return stringBuilder;
        for (Map.Entry<String, String> entry : params.entrySet()){
            if (entry.getValue() == null) continue;
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" = ");
            stringBuilder.append("'");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("'");
            stringBuilder.append(" and ");
        }
        return stringBuilder.delete(stringBuilder.lastIndexOf(" and "), stringBuilder.length());
    }

    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
//        params.put("name", null);
//        params.put("country", "Ukraine");
//        params.put("city", "Kiev");
//        params.put("age", "30");

        System.out.println(getCondition(params).toString());
    }
}
