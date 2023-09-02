package com.javarush.task.task37.task3701;

import org.apache.commons.collections4.iterators.ArrayListIterator;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

/* 
Круговой итератор
*/

public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }

        ListIterator iterator = list.listIterator();
        count = 0;
        while (iterator.hasNext()) {
            count++;
            if ((Integer) iterator.next() == 2) iterator.remove();
            if (count == 10) break;
        }

        System.out.println();
        count = 0;
        for (Integer i : list) {
            count++;
            System.out.print(i + " ");
            if (count == 10) break;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        private ListIterator<T> iterator = Solution.super.listIterator();

        public boolean hasNext() {
            if (!iterator.hasNext()) iterator = Solution.super.listIterator();
            return iterator.hasNext();
        }

        public T next() {
            return iterator.next();
        }

        public void remove() {
            iterator.remove();
        }
    }
}
