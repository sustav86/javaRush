package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) return;

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        Set<File> allFiles = new TreeSet<>();
        walkingByDirectories(path, allFiles);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");
        resultFileAbsolutePath.renameTo(allFilesContent);
        try {
            FileInputStream input = null;
            FileOutputStream out = new FileOutputStream(allFilesContent);
            for (File currentFile : allFiles) {
                input = new FileInputStream(currentFile);
                out.write(input.read(new byte[(int) currentFile.length()]));
                out.write(new String(Files.readAllBytes(Paths.get(currentFile.getAbsolutePath()))).getBytes());
//                out.write("\\n");

            }
            out.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }




    }

    public static void walkingByDirectories(File path, Set<File> allFiles) {
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                if (file.list().length == 0) {
                    file.delete();
                } else {
                    walkingByDirectories(file, allFiles);
                }
            } else {
                if (file.length() > 50) {
                    file.delete();
                } else {
                    allFiles.add(file);
                }
            }
        }

    }
}
