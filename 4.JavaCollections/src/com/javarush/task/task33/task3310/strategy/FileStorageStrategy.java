package com.javarush.task.task33.task3310.strategy;

import java.nio.file.Files;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;

        long currentBucketSize = table[bucketIndex].getFileSize();
        if (currentBucketSize > maxBucketSize) maxBucketSize = currentBucketSize;
    }

    public Entry getEntry(Long key) {
        if (size == 0) return null;

        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index].getEntry(); entry != null; entry = entry.next) {
            if (key.equals(entry.key)) return entry;
        }
        return null;
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (maxBucketSize >= bucketSizeLimit) {
            resize(2 * table.length);
            hash = key.hashCode();
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    void resize(int newCapacity) {
        FileBucket[] newTab = new FileBucket[newCapacity];
        for (int i = 0; i < newTab.length; i++) {
            newTab[i] = new FileBucket();
        }

        transfer(newTab);
        for (int i = 0; i < table.length; i++) {
            table[i].remove();
        }

        table = newTab;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        maxBucketSize = 0;
        long currentBucketSize;

        for (FileBucket fileBucket : table) {
            Entry entry = fileBucket.getEntry();

            while (entry != null) {
                Entry next = entry.next;
                int bucketIndex = indexFor(entry.getKey().hashCode(), newCapacity);
                entry.next = newTable[bucketIndex].getEntry();
                newTable[bucketIndex].putEntry(entry);
                entry = next;
            }

            currentBucketSize = fileBucket.getFileSize();
            if (currentBucketSize > maxBucketSize) maxBucketSize = currentBucketSize;
        }
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (FileBucket fileBucket : table) {
            for (Entry e = fileBucket.getEntry(); e != null; e = e.next) {
                if (e.value.equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = key.hashCode();
        int bucketIndex = indexFor(hash, table.length);
        for (Entry e = table[bucketIndex].getEntry(); e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, bucketIndex);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fileBucket : table) {
            for (Entry e = fileBucket.getEntry(); e != null; e = e.next) {
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

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
