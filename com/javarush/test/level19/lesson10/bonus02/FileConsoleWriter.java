package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{
    private static final int WRITE_BUFFER_SIZE = 1024;
    private char[] writeBuffer;

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        super.write(cbuf);
//        write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(int c) throws IOException
    {
//        super.write(c);

        if (writeBuffer == null){
            writeBuffer = new char[WRITE_BUFFER_SIZE];
        }
        writeBuffer[0] = (char) c;
        write(writeBuffer, 0, 1);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        System.out.println(String.valueOf(cbuf, off, len));
        super.write(cbuf, off, len);

    }

    @Override
    public void write(String str) throws IOException
    {
        super.write(str);
//        write(str, 0, str.length());
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
//        super.write(str, off, len);

        char cbuf[];
        if (len <= WRITE_BUFFER_SIZE) {
            if (writeBuffer == null) {
                writeBuffer = new char[WRITE_BUFFER_SIZE];
            }
            cbuf = writeBuffer;
        } else {    // Don't permanently allocate very large buffers.
            cbuf = new char[len];
        }
        str.getChars(off, (off + len), cbuf, 0);
        write(cbuf, 0, len);


    }


}
