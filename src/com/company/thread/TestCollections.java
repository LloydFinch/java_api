package com.company.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Name: TestCollections
 * Author: lloydfinch
 * Function: TestCollections
 * Date: 2020-11-10 11:20
 * Modify: lloydfinch 2020-11-10 11:20
 */
public class TestCollections {

    private void testCopyOnSet() {

        ArrayList<String> list1  = new ArrayList<>();

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.addIfAbsent("hello");
        list.add("world");
        list.get(1);

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("hello");
    }
}
