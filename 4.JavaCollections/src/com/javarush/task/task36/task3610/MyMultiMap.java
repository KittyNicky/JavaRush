package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (List<V> values : map.values()) {
            size += values.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            if (map.get(key).size() < repeatCount) {
                map.get(key).add(value);
                return map.get(key).get(map.get(key).size() - 2);
            } else {
                List<V> values = map.get(key);
                values.add(value);
                values.remove(0);
                return values.get(repeatCount - 2);
            }
        } else {
            map.put(key, new ArrayList<V>() {{
                add(value);
            }});
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            List<V> values = map.get(key);
            V removeValue = values.remove(0);
            if (values.isEmpty()) map.remove(key);
            return removeValue;
        } else return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (List<V> value : map.values()) {
            values.addAll(value);
        }
        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<V> values : map.values()) {
            for (V v : values) {
                if (value.equals(v)) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}