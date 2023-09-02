package com.javarush.task.task19.task1902;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/* 
Адаптер
*/

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }

    public static void main(String[] args) {
        Date date = new Date(2000, 10, 30);
        System.out.println(date.getYear() + ":" + date.getMonth() + ":" + date.getDate());
    }


}

