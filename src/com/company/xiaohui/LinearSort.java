package com.company.xiaohui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Name: LinearSort
 * Author: lloydfinch
 * Function: LinearSort linear sort
 * Date: 2020-07-22 09:28
 * Modify: lloydfinch 2020-07-22 09:28
 */
public class LinearSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 101, 102, 103, 105, 104, 103, 102, 101};
        LinearSort linearSort = new LinearSort();

        linearSort.printArr(nums);
        linearSort.linearSort2(nums);
        linearSort.printArr(nums);
    }

    /**
     * basic version
     * max+1 as length
     */
    public void linearSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int max = nums[0];
        for (int value : nums) if (value > max) max = value;
        int[] temp = new int[max + 1];
        for (int num : nums) temp[num]++;

        int index = 0;
        for (int i = 0; i < temp.length; i++) while (temp[i]-- > 0) nums[index++] = i;
    }

    /**
     * opt version
     * max - min + 1 as length
     * min as offset
     */
    public void linearSort2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        //create temp array
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int[] temp = new int[max - min + 1];

        //store nums to temp array
        for (int num : nums) temp[num - min]++;

        //transfer temp array to nums
        int index = 0;
        for (int i = 0; i < temp.length; i++) while (temp[i]-- > 0) nums[index++] = i + min;
    }

    private void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
