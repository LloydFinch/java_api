package com.curoutine;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Name: ImnCoroutine
 * Author: lloydfinch
 * Function: ImnCoroutine
 * Date: 2020-09-03 15:58
 * Modify: lloydfinch 2020-09-03 15:58
 */
public class ImnCoroutine {

    public static void main(String[] args) {
        CThread cThread = new CThread();
        cThread.start();

        CRunnable task1 = new CRunnable() {
            @Override
            public void run1() {
                for (int i = 1; i < 1000; i++) {
                    System.out.println("task1: " + i);
                    delay(100);
                }
            }
        };

        CRunnable task2 = new CRunnable() {
            @Override
            public void run1() {
                for (int i = 1; i < 1000; i++) {
                    System.out.println("task2: " + i);
                    delay(200);
                }
            }
        };

        cThread.post(task1);
        cThread.post(task2);


        //延时10s关闭
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cThread.shutDown();

    }

    public static class CThread extends Thread {
        private LinkedList<CRunnable> runnables = new LinkedList<>();
        private volatile boolean start = true;

        public void post(CRunnable task) {
            runnables.offer(task);
        }

        @Override
        public void run() {
            while (start) {
                long current = System.currentTimeMillis();
                CRunnable task = runnables.poll();
                if (task != null && task.when.get() <= current) {
                    task.run();
                }
            }
        }

        public void shutDown() {
            start = false;
        }
    }

    public static class CRunnable implements Runnable, Comparable<CRunnable> {
        public volatile AtomicLong when; //执行时间

        public CRunnable() {
            this.when = new AtomicLong(System.currentTimeMillis());
        }

        /**
         * 让child实现
         */
        public void run1() {

        }

        /**
         * 向下级屏蔽此方法
         */
        @Override
        public final void run() {
            run1();
        }

        @Override
        public int compareTo(CRunnable o) {
            return (int) (when.get() - o.when.get());
        }

        /**
         * 任务执行时间延迟time
         */
        public void delay(long time) {
            when.addAndGet(time);
        }
    }
}


