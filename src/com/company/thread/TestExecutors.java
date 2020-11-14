package com.company.thread;

import java.util.concurrent.*;

/**
 * Name: TestExecutors
 * Author: lloydfinch
 * Function: TestExecutors
 * Date: 2020-11-13 11:36
 * Modify: lloydfinch 2020-11-13 11:36
 */
public class TestExecutors {
    public static void main(String[] args) {
//        testFuture();
        test();
    }

    private static void test() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("this is a task");
        executor.execute(task);
    }


    private static void testFuture() {
        //定义任务
        Callable<String> callable = () -> {
            Thread.sleep(3000);
            return "hello";
        };
        //创建执行器
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //提交任务
        Future<String> future = executorService.submit(callable);
        try {
            //阻塞获取执行结果，只要结果没返回，就会一直阻塞
            String result = future.get();
            //关闭执行器
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
