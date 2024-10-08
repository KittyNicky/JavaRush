package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.stream = new FileOutputStream(fileName, true);
        in.defaultReadObject();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "/Users/nikita.z/myJava/ideaProject/docs/1.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));

        Solution solution = new Solution(fileName);
        solution.writeObject("writeString");
        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();

        Solution loadedSolution = (Solution) inputStream.readObject();
        loadedSolution.writeObject("writeString2");
        inputStream.close();

    }
}
