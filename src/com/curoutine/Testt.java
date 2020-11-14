package com.curoutine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Name: Testt
 * Author: lloydfinch
 * Function: Testt
 * Date: 2020-09-03 15:35
 * Modify: lloydfinch 2020-09-03 15:35
 */
public class Testt {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task1");
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task2");
                }
            }
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(task1);
        executor.submit(task2);
    }
}
