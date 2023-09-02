package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;
    private Path path;
    private boolean isHidden;
    private boolean isExecutable;
    private boolean isDirectory;
    private boolean isWritable;

    public Solution(String pathToFile) {
        path = Paths.get(pathToFile);
        try {
            isHidden = Files.isHidden(path);
            isExecutable = Files.isExecutable(path);
            isDirectory = Files.isDirectory(path);
            isWritable = Files.isWritable(path);
            fileData = new ConcreteFileData(isHidden, isExecutable, isDirectory, isWritable);
        } catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
