package com.company.leetcode;

/**
 * Name: TwoSum2
 * Author: lloydfinch
 * Function: TwoSum2
 * Date: 2020-07-20 14:55
 * Modify: lloydfinch 2020-07-20 14:55
 */
public class TwoSum2 {

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();

        int[] numbers = new int[]{-3, 3, 4, 9};
        int target = 0;
        int[] result = twoSum2.twoSum(numbers, target);
        System.out.println(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;
        int start = 0;
        int end = numbers.length - 1;
        int sum;
        while (start < end) {
            sum = numbers[start] + numbers[end];
            if (sum == target) return new int[]{start + 1, end + 1};
            if (sum > target) end--;
            if (sum < target) start++;
        }
        return null;
    }
}
