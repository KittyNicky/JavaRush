package com.javarush.task.task31.task3113;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor {
    private Path path;
    private int countFolders;
    private int countFiles;
    private long size;

    public void setPath(Path path) {
        this.path = path;
    }

    public int getCountFolders() {
        return countFolders;
    }

    public int getCountFiles() {
        return countFiles;
    }

    public long getSize() {
        return size;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        size += attrs.size();
        countFiles++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        if (!dir.equals(path)) countFolders++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public String toString() {
        String folders = "Всего папок - " + getCountFolders();
        String files = "Всего файлов - " + getCountFiles();
        String size = "Общий размер - " + getSize();

        return String.format("%s\n%s\n%s", folders, files, size);
    }

    public static boolean isDirectory(Path path) {
        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return true;
        }
        return false;
    }
}

