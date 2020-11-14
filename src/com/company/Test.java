package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Name: Test
 * Author: lloydfinch
 * Function: Test
 * Date: 2020-07-14 13:42
 * Modify: lloydfinch 2020-07-14 13:42
 */
public class Test {

    public static void main(String[] args) {
//        Object lock = new Object();
//        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.getAndAddInt(lock, 10, 1);
//
//        AtomicInteger atomicInteger = new AtomicInteger();
//
//
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        threadLocal.set("hello");

//        Test test = new Test();
//        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 100, 12, 31};
//        printArr(nums);
//        test.practiceLiner(nums);
//        printArr(nums);

//        int[][] matrix = new int[][]{{4, 6, 7, 8}, {1, 2, 3, 5}, {10, 1, 4, 2}};
//        int path = test.practice4(matrix);
//        System.out.println("path is " + path);
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "android");
        String key1 = new String("hello");
        System.out.println(map.containsKey(key1));
    }


    public class MThread {
        MThreadLocal.MThreadLocalMap threadLocalMap = null;
    }

    public static class MThreadLocal {
        public static class MThreadLocalMap {

        }
    }

    private void practice(int[] nums, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left != right) {
            while (nums[right] > pivot && right > left) right--;
            while (nums[left] <= pivot && left < right) left++;
            if (left < right) swap(nums, left, right);
        }
        swap(nums, left, start);
        practice(nums, start, left - 1);
        practice(nums, left + 1, end);
    }

    private void practice2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }
        int[] temp = new int[max - min + 1];
        for (int num : nums) temp[num - min]++;
        int index = 0;
        for (int i = 0; i < temp.length; i++) while (temp[i]-- > 0) nums[index++] = i + min;
    }

    public void practice3(int[] nums) {
        if (nums == null || nums.length == 0) return;
        double max = nums[0];
        double min = nums[0];
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }
        double d = max - min;
        int bucketLength = nums.length;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>(bucketLength);
        for (int i = 0; i < bucketLength; i++) buckets.add(new LinkedList<>());
        for (int num : nums) buckets.get((int) ((num - min) / d * (bucketLength - 1))).add(num);
        for (LinkedList<Integer> bucket : buckets) Collections.sort(bucket);
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) for (Integer num : bucket) nums[index++] = num;
    }

    public int practice4(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < rows; i++) dp[i][0] = dp[i - 1][0] + matrix[i][0];
        for (int j = 1; j < columns; j++) dp[0][j] = dp[0][j - 1] + matrix[0][j];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + matrix[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    /**
     * divider and conquer
     */
    public void practiceQuick(int[] number, int start, int end) {
        if (start > end) return;
        int left = start;
        int right = end;
        int pivot = number[left];

        while (left < right) {
            while (number[right] > pivot && right > left) right--;
            while (number[left] <= pivot && left < right) left++;
            if (left < right) swap(number, left, right);
        }

        swap(number, left, start);
        practiceQuick(number, start, left - 1);
        practiceQuick(number, left + 1, end);
    }

    /**
     * use array index
     */
    public void practiceLiner(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (min < max) min = num;
        }
        int[] arr = new int[max - min + 1];
        for (int num : nums) arr[num - min]++;
        int index = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i]-- > 0) nums[index++] = min + i;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

