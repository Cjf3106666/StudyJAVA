package com.cjf.demo;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class Demo36_SkipListAndTreeMap {


    public static void main(String[] args) {

        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> SkipListMap = new ConcurrentSkipListMap<>();

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("5a", 5);
        hashMap.put("8a", 8);
        hashMap.put("1a", 1);
        hashMap.put("3asd", 3);
        hashMap.put("2a", 2);
        hashMap.put("6a", 6);
        hashMap.put("4asda", 4);
        hashMap.put("4a", 4);
        hashMap.put("8a", 8);

        treeMap.putAll(hashMap);
        SkipListMap.putAll(hashMap);
        System.out.println("HashMap: " + hashMap);
        System.out.println("======================================");
        System.out.println("TreeMap: " + treeMap);
        System.out.println("======================================");
        System.out.println("SkipListMap: " + SkipListMap);
        System.out.println("======================================");
        Map<String, Integer> linkHashMap = new LinkedHashMap<>();
        linkHashMap = Collections.synchronizedMap(linkHashMap);
        linkHashMap.put("5a", 5);
        linkHashMap.put("8a", 8);
        linkHashMap.put("1a", 1);
        linkHashMap.put("3asd", 3);
        linkHashMap.put("2a", 2);
        linkHashMap.put("6a", 6);
        linkHashMap.put("4asda", 4);
        linkHashMap.put("4a", 4);
        linkHashMap.put("8a", 8);
        System.out.println("LinkedHashMap" + linkHashMap);
    }

}
