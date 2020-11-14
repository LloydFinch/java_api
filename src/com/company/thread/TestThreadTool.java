package com.company.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Name: TestThreadTool
 * Author: lloydfinch
 * Function: TestThreadTool
 * Date: 2020-11-04 11:26
 * Modify: lloydfinch 2020-11-04 11:26
 */
public class TestThreadTool {
    public static void main(String[] args) {
        TestThreadTool tool = new TestThreadTool();
        tool.test3();
    }

    /**
     * LockSupport
     */
    private static void demoLockSupport() {

    }

    /**
     * 可重入锁
     */
    private static void demoReentrantLock() {

    }

    /**
     * 信号量
     */
    private static void demoSemaphore() {
        //许可证为10
        int permits = 10;
        //创建信号量
        Semaphore semaphore = new Semaphore(permits);
        for (int i = 1; i < 100; i++) {
            Thread thread = new Thread(() -> {
                //尝试获取许可证
                if (semaphore.tryAcquire()) {
                    //获取到了就执行
                    try {
                        System.out.println("run in" + Thread.currentThread().getName());
                    } finally {
                        //执行完毕释放许可证
                        semaphore.release();
                    }
                }
            });
            thread.start();
        }

        //也可以在另一个线程释放许可证，这里在UI线程释放许可
        for (int i = 0; i < permits; i++) semaphore.release();
    }

    /**
     * 倒计时门闩
     */
    private static void demoCountDownLatch() {
        int count = 0;
        CountDownLatch latch = new CountDownLatch(count);
        Thread thread = new Thread(() -> {
            try {
                System.out.println("start await");
                latch.await();
                System.out.println("run: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start countDown");
        latch.countDown();
    }

    /**
     * 循环栏栅
     */
    private static void demoCyclicBarrier() {

    }

    public static class SafeList {
        //创建读写锁
        private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //获取读锁
        private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        //获取写锁
        private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        //创建数据
        private List<String> datas = new ArrayList<>();

        /**
         * 写数据 用写锁保护
         */
        public void add(String str) {
            writeLock.lock();
            try {
                datas.add(str);
            } finally {
                writeLock.unlock();
            }
        }

        /**
         * 读数据，用读锁保护
         */
        public String get(int index) {
            readLock.lock();
            try {
                return datas.get(index);
            } finally {
                readLock.unlock();
            }
        }
    }


    public class Test {
        //定义许可证
        private int permits = 10;
        //创建信号量
        private Semaphore semaphore = new Semaphore(permits);

        public boolean enter() {
            //如果没有获取到许可证，就直接返回false
            if (!semaphore.tryAcquire()) return false;
            //获取到就进入
            System.out.println("enter");
            return true;
        }

        public void exit() {
            //退出就释放许可证
            semaphore.release();
        }
    }


    public static class Frog extends Thread {
        private final CountDownLatch latch;

        public Frog(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                //等待
                latch.await();
                System.out.println("Frog " + Thread.currentThread().getName() + " start，time: " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test() throws InterruptedException {
        //创建门闩
        CountDownLatch latch = new CountDownLatch(1);
        //创建5只青蛙并同时等待
        for (int i = 1; i <= 5; i++) new Frog(latch).start();
        //倒计时3秒
        Thread.sleep(3000);
        //开跑!
        latch.countDown();
    }


    public class FileWriter extends Thread {
        private CountDownLatch latch;

        public FileWriter(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                //随便休眠几秒，来模拟写文件
                Thread.sleep((long) Math.abs(Math.random() * 100));
                System.out.println("File " + Thread.currentThread().getName() + " write finish");
            } catch (InterruptedException e) {
                //自行处理中断
            } finally {
                //写完了，就减一个门闩
                latch.countDown();
            }
        }
    }

    public void test1() throws InterruptedException {
        int count = 10;
        CountDownLatch latch = new CountDownLatch(count);
        //创建100个线程去写文件
        for (int i = 0; i < count; i++) new FileWriter(latch).start();

        //等待文件写完
        latch.await();
        System.out.println("all finish");
    }

    public class FileWriter2 extends Thread {
        private CyclicBarrier barrier;

        public FileWriter2(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                //随便休眠几秒，来模拟写文件
                Thread.sleep((long) Math.abs(Math.random() * 100));
                System.out.println("File " + Thread.currentThread().getName() + " write finish");

                //写完了，在集合点等待
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void test2() {
        int count = 10;
        //创建栅栏，指定最后到达的线程要执行的操作
        CyclicBarrier barrier = new CyclicBarrier(count, () -> {
            //最后到达的线程执行这一步
            System.out.println("all finish, run in " + Thread.currentThread().getName());
        });
        //创建10个线程去写文件
        for (int i = 0; i < count; i++) new FileWriter2(barrier).start();
    }


    public class Car extends Thread {
        private CyclicBarrier barrier;

        public Car(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long) Math.abs(Math.random() * 100));
                System.out.println(Thread.currentThread().getName() + "到达集合点A");
                //到达第一个集合点
                barrier.await();

                Thread.sleep((long) Math.abs(Math.random() * 100));
                System.out.println(Thread.currentThread().getName() + "到达集合点B");
                //到达第二个集合点
                barrier.await();

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private void test3() {
        int count = 5;
        //创建栅栏，指定最后到达的线程要执行的操作
        CyclicBarrier barrier = new CyclicBarrier(count, () -> {
            //最后到达的线程执行这一步
            System.out.println("all finish, run in " + Thread.currentThread().getName());
        });
        //创建10个线程去写文件
        for (int i = 0; i < count; i++) new Car(barrier).start();
    }
}
