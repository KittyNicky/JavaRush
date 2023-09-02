package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    public final int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        if (size == 0) return null;

        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (key.equals(entry.key)) return entry;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry[] newTab = new Entry[newCapacity];
        transfer(newTab);
        table = newTab;
        threshold = (int) (DEFAULT_LOAD_FACTOR * newCapacity);
    }

    void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;
        for (Entry entry : table) {
            for (Entry e = entry; e != null; e = entry.next) {
                int bucketIndex = indexFor(hash(e.getKey()), newCapacity);
                e.next = newTable[bucketIndex];
                newTable[bucketIndex] = e;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (size >= threshold) {
            resize(2 * table.length);
            hash = hash(key);
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry next = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, next);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry entry : table) {
            for (Entry e = entry; e != null; e = e.next) {
                if (value.equals(e.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int bucketIndex = indexFor(hash, table.length);
        for (Entry e = table[bucketIndex]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, bucketIndex);
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : table) {
            for (Entry e = entry; e != null; e = e.next) {
                if (value.equals(e.value)) {
                    return e.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null) return entry.getValue();
        return null;
    }
}
