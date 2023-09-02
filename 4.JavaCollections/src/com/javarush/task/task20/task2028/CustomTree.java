package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    ArrayList<Entry<String>> entries = new ArrayList<>();

    public CustomTree() {
        this.root = new Entry<>("root");
        entries.add(root);
    }

    @Override
    public boolean add(String s) {
        Entry<String> element = new Entry<String>(s);

        for (int i = 0; i < entries.size(); i++) {
            Entry<String> entry = entries.get(i);

            if (!entry.isAvailableToAddChildren()) continue;

            if (entry.availableToAddLeftChildren) {
                entries.add(element);
                element.parent = entry;
                entry.leftChild = element;
                entry.availableToAddLeftChildren = false;
                return true;
            } else if (entry.availableToAddRightChildren) {
                entries.add(element);
                element.parent = entry;
                entry.rightChild = element;
                entry.availableToAddRightChildren = false;
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        Queue<Entry<String>> queue = new LinkedList<>();
        for (Entry<String> e : entries) {
            if (e.elementName.equals(o)) {
                queue.offer(e);
                break;
            }
        }

        Entry<String> entry;
        while ((entry = queue.poll()) != null) {
            if (entry.leftChild != null) {
                queue.offer(entry.leftChild);
            }
            if (entry.rightChild != null) {
                queue.offer(entry.rightChild);
            }
            entries.remove(entry);
        }

        int countEntriesWhoCanAddChildren = 0;
        for (Entry e : entries) {
            if (e.isAvailableToAddChildren()) countEntriesWhoCanAddChildren++;
        }

        if (countEntriesWhoCanAddChildren == 0) {
            for (Entry e : entries) {
                if (!entries.contains(e.leftChild)) e.availableToAddLeftChildren = true;
                if (!entries.contains(e.rightChild)) e.availableToAddRightChildren = true;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return entries.size() - 1;
    }

    public String getParent(String elementName) {
        for (Entry<String> entry : entries) {
            if (entry.elementName.equals(elementName))
                return entry.parent.elementName;
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            if (availableToAddLeftChildren || availableToAddRightChildren) return true;
            else return false;
        }
    }
}
