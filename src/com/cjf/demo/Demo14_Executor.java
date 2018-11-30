package com.cjf.demo;

import java.util.concurrent.Executor;

public class Demo14_Executor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new Demo14_Executor().execute(() -> System.out.println("Hello Executor"));
    }
}
