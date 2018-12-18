package com.cjf.demo;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo37_LRU {
    static private Integer initialCapacity = 16;
    static private Float loadFactor = 0.75f;
    static private Integer maxSize = (int) Math.ceil(initialCapacity * loadFactor);
    private static Map<String, Object> cache;

    static {
        cache = new LinkedHashMap<String, Object>(initialCapacity, loadFactor, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return cache.size() > maxSize;
            }
        };
        cache = Collections.synchronizedMap(cache);
    }

    public Object setKey(String Key, Object value) {
        return cache.put(Key, value);
    }

    public Object getKey(String Key) {
        return cache.get(Key);
    }

    public Object DeleteKey(String Key) {
        return cache.remove(Key);
    }

    public Object AllKeys() {
        return cache.keySet();
    }

    public void Clear() {
        cache.clear();

    }

    public static void main(String[] args) {
        cache.put("asd1", 1);
        cache.put("as51", 2);
        cache.put("a8d1", 3);
        cache.put("a9d1", 4);
        cache.put("asd2", 5);
        cache.put("as52", 6);
        cache.put("a8d2", 7);
        cache.put("a9d2", 8);
        cache.put("asd3", 9);
        cache.put("as53", 10);
        cache.put("a8d3", 11);
        cache.put("a9d3", 12);
        cache.put("asd4", 13);
        cache.put("as54", 14);
        cache.put("a8d4", 15);
        cache.put("a9d4", 16);
        cache.get("a8d3");
        cache.get("asd3");
        System.out.println(cache);


    }


}
