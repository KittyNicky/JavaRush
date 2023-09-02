package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf).substring(off, off + len));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(new String(cbuf));
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/nikita.z/myJava/ideaProject/docs/1.txt";
        char[] chars = {'a', '1', '2', 'b', 'c'};
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(fileName);
        fileConsoleWriter.write("writeStr");
        fileConsoleWriter.write(chars);
        fileConsoleWriter.write(5);
        fileConsoleWriter.write("writeStr", 1, 4);
        fileConsoleWriter.write(chars, 1, 2);
    }

}
