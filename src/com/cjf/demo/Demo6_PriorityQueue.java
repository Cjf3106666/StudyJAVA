package com.cjf.demo;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo6_PriorityQueue {

    private static Queue queue = new LinkedBlockingQueue();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        PriorityQueue queue = new PriorityQueue(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(queue.poll() + " ");
        }


        System.out.println();

        queue = new PriorityQueue(Collections.reverseOrder());

        queue.addAll(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();

    }


}
