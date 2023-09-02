package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> cls;

    public Generator(Class<T> cls) {
        this.cls = cls;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return cls.newInstance();
    }
}
