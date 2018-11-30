package com.cjf.demo;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3_ReentrantLockCAndP {
    final static LinkedList<Integer> list = new LinkedList<>();
    final static int MAX_SIZE = 10;
    static int count = 0;
    final static ReentrantLock lock = new ReentrantLock(true);
    final Condition notFull = lock.newCondition();//写线程条件
    final Condition notEmpty = lock.newCondition();


    public void provider() {
        try {
            lock.lock();
            while (list.size() == MAX_SIZE) {
                notFull.await();
            }
            list.add(1);
            count++;
            System.out.println(Thread.currentThread().getName() + "生产了一个产品,剩余产品如下");
            System.out.println(list);
            System.out.println("--------------------------------------------");
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }


    }

    public void consumer() {

        try {
            lock.lock();
            while (list.size() == 0) {
                notEmpty.await();
            }

            list.removeFirst();
            count--;
            System.out.println(Thread.currentThread().getName() + "消费了一个产品,剩余产品如下");
            System.out.println(list.size() == 0 ? "没有产品了" : list);
            System.out.println("--------------------------------------------");
            notEmpty.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo3_ReentrantLockCAndP test = new Demo3_ReentrantLockCAndP();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.consumer();
                }

            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.provider();
                }

            }).start();
        }
    }


}
