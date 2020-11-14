package com.company.thread;

import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executors;

/**
 * Name: TestThread
 * Author: lloydfinch
 * Function: TestThread
 * Date: 2020-10-27 11:55
 * Modify: lloydfinch 2020-10-27 11:55
 */
public class TestThread {
    private int a = 1;

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put("key","value");

        Executors.newCachedThreadPool();

        skipListMap.size();
    }

    private static void test(List<? extends Integer> list) {

    }

    private <T> void test2(List<? extends T> list) {

    }
}
