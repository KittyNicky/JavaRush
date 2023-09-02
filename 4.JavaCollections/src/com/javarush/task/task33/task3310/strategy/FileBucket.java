package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.Helper;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(Integer.toHexString(hashCode()), ".tmp");
            path.toFile().deleteOnExit();
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
        }
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0;
        }
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(entry);
        } catch (IOException e) {
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Entry entry = (Entry) ois.readObject();
            return entry;
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
        }
    }

}
