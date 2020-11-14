package com.company.xiaohui;

/**
 * Name: LinkedHasCircle
 * Author: lloydfinch
 * Function: LinkedHasCircle
 * Date: 2020-07-20 17:15
 * Modify: lloydfinch 2020-07-20 17:15
 */
public class LinkedHasCircle {

    public static void main(String[] args) {

    }

    /**
     * 链表是否有环
     * 快慢指针法
     */
    public boolean isCircle(ListNode node) {
        if (node == null) return false;
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * 求链表环长
     */
    public int circleLength(ListNode node) {
        if (node == null) return 0;
        ListNode slow = node;
        ListNode fast = node;
        int length = 0;
        boolean twice = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                if (twice) return length;
                twice = true;
            }
            if (twice) length++;
        }

        return length;
    }

    /**
     * 获取链表环的起点
     */
    public int circleStart(ListNode node) {


        return -1;
    }

    public class ListNode {
        public int val;
        public ListNode next;
    }

}
