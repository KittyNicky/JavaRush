package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Paths;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/nikita.z/myJava/ideaProject/docs/2.txt";
        Cat cat = convertFromJsonToNormal(fileName, Cat.class);
        System.out.println(cat);
    }

    @JsonAutoDetect
    public class Cat {
        String name;
        int age;
        int weight;

        public Cat() {
        }
    }
}
