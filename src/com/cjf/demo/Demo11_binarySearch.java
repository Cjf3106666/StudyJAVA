package com.cjf.demo;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Demo11_binarySearch {
    static String a[] = {"123", "456", "789", "101112", "13141516"};

    public static void main(String[] args) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, "123"));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, "123", Collections.reverseOrder()));
        String b[] = new String[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        System.out.println(Arrays.toString(b));
    }
}
