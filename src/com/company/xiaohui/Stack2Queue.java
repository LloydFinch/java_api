package com.company.xiaohui;

import java.util.Stack;

/**
 * Name: Stack2Queue
 * Author: lloydfinch
 * Function: Stack2Queue
 * Date: 2020-07-30 09:55
 * Modify: lloydfinch 2020-07-30 09:55
 */
public class Stack2Queue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /**
     * enqueue
     */
    public void offer(Integer element) {
        in.push(element);
    }

    /**
     * dequeue
     */
    public Integer poll() {
        if (!out.isEmpty()) return out.pop();
        if (in.isEmpty()) return null;
        while (!in.isEmpty()) out.push(in.pop());
        return out.pop();
    }

    /**
     * test
     */
    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.offer(1);
        stack2Queue.offer(2);
        stack2Queue.offer(3);
        int a = stack2Queue.poll();
        int b = stack2Queue.poll();
        System.out.println(a);
        System.out.println(b);
    }
}
