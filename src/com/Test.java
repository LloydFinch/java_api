package com;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * Name: Test
 * Author: lloydfinch
 * Function: Test
 * Date: 2020-08-26 18:34
 * Modify: lloydfinch 2020-08-26 18:34
 */
public class Test {
    public static void main(String[] args) {
//        long[] arr = new long[2 << 20];
//        long n = 10000000000L;
//        long start = System.currentTimeMillis();
//        for (long i = 0; i < n; i++) {
//            Thread thread = new Thread(() -> System.out.println("."));
//            try {
//                thread.start();
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

//        testStream();
//        callJS();
//        base64();
//        arrayParallel();
//        testAPI();

//        testAQS();

        testRandom();
    }

    private static void testParameter(String name) {

    }

    private static void testStream() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.stream().filter(integer -> integer >= 5).forEach(System.out::println);
    }

    /**
     * 调用js函数
     */
    private static void callJS() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        try {
            System.out.println(engine.eval("function f() {return 'Hello ';}; f() + 'world!';"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    private static void base64() {
        String str = "hello world";
        String encodeStr = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println("after encode: " + encodeStr);

        String decodeStr = new String(Base64.getDecoder().decode(encodeStr), StandardCharsets.UTF_8);
        System.out.println("after decode: " + decodeStr);
    }

    private static void arrayParallel() {
        int[] arr = new int[]{9, 5, 8, 4, 3, 7, 2, 1, 7};
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void testAPI() {
        List<String> list = new ArrayList<>();
        List<String> list1 = Collections.unmodifiableList(list);
        list1.add(""); //exception

        String hello = "hello";
    }

    /**
     * 集合框架
     */
    private static void testCollection() {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("hello", "world");
    }

    private static void testAQS() {
        Thread thread = new Thread(() -> {
            System.out.println("thread running");
            LockSupport.park();
            System.out.println("finish");
        });
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ready to unpark");
        LockSupport.unpark(thread);
    }

    private static void testFuture() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "test future";
            }
        });
        try {
            String result = future.get();
            System.out.println("result is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //取消
//        boolean cancel = future.cancel(true);
    }

    private static void testRandom() {
        int len = 100;
        for (int i = 0; i < len; i++) {
            System.out.println(getRandomHanChar());
        }
    }

    public static char getRandomHanChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }
}
