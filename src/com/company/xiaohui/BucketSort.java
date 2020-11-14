package com.company.xiaohui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Name: BucketSort
 * Author: lloydfinch
 * Function: BucketSort
 * Date: 2020-07-22 16:03
 * Modify: lloydfinch 2020-07-22 16:03
 */
public class BucketSort {
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -10};


        bucketSort.printArr(nums);
        bucketSort.bucketSort(nums);
        bucketSort.printArr(nums);
    }

    /**
     * divide(by liner sort)
     */
    public void bucketSort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        //get d
        double max = nums[0];
        double min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        double d = max - min;

        //create bucket(bucket length equals nums length)
        int bucketSize = nums.length;
        List<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) buckets.add(new LinkedList<>());

        //put nums into bucket
        //mul first(other result is zero)
        //int index = (nums[i] - min) / d * bucketSize;
        //nums[i] - min : nums[i] 距起点的距离
        //(nums[i] - min) /d : 距离起点的距离占d的百分比
        //(nums[i] - min) /d * bucketSize : 将这个坐标映射到bucketSize上面，得到对应的bucket的位置
        for (int num : nums) buckets.get((int) ((num - min) * (bucketSize - 1) / d)).add(num);

        //sort bucket
        for (LinkedList<Integer> bucket : buckets) Collections.sort(bucket);

        //pour bucket into nums
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) for (Integer integer : bucket) nums[index++] = integer;
    }

    public void printArr(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
