package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final Long getKey() {
        return key;
    }

    public final String getValue() {
        return value;
    }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Entry) {
            Entry e = (Entry) o;
            if (key.equals(e.getKey()) && value.equals(e.getValue())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return key + "=" + value;
    }
}
