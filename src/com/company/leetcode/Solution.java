package com.company.leetcode;

/**
 * Name: Solution
 * Author: lloydfinch
 * Function: Solution
 * Date: 2020-11-14 17:37
 * Modify: lloydfinch 2020-11-14 17:37
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        int[] ints = solution.relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int i : arr1) bucket[i]++;

        int[] result = new int[arr1.length];
        int index = 0;
        for (int i : arr2) while (bucket[i]-- > 0) result[index++] = i;
        for (int i = 0; i < bucket.length; i++) while (bucket[i]-- > 0) result[index++] = i;
        return result;
    }
}
