package com.cjf.demo;

import java.util.*;

public class Demo7_Imp_iterable implements Iterable<String> {
    static String[] str = {"154646", "aaaaa", "bbbbb", "cccccccc"};
    static int index = 0;

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("1", "2");
        map.put("2", "22");
        map.put("3", "222");

        System.out.println(map);
        for (String s : map.values()
                ) {
            System.out.println(s);
        }

        for (String a : new Demo7_Imp_iterable()) {
            System.out.println(a);
        }

    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < str.length;
            }

            @Override
            public Object next() {
                return str[index++];
            }
        };
    }
}
