package com.company.leetcode;

import java.util.*;

/**
 * Name: PreKCount
 * Author: lloydfinch
 * Function: PreKCount
 * Date: 2020-09-07 18:07
 * Modify: lloydfinch 2020-09-07 18:07
 */
public class PreKCount {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 66, 6, 6, 6};
        int k = 1;
        int[] ints = topKFrequent2(arr, k);

        for (int i : ints) System.out.println(i);
    }


//    public static int[] topKFrequent(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return nums;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (Integer num : nums) {
//            Integer value = map.getOrDefault(num, 0);
//            if (value == 0) {
//                map.put(num, 1);
//            } else {
//                map.put(num, map.get(num) + 1);
//            }
//        }
//
//        //fuck
//    }

    public static int[] topKFrequent2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int length = max - min + 1;
        int[] temp = new int[length];
        for (int num : nums) temp[num - min]++;
        for (int i = 0; i < temp.length; i++) {
            System.out.println((i + min) + " : " + temp[i]);
        }

        return temp;
    }
}
