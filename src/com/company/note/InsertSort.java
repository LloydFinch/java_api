package com.company.note;

/**
 * Name: Insert
 * Author: lloydfinch
 * Function: Insert
 * Date: 2020-10-16 17:11
 * Modify: lloydfinch 2020-10-16 17:11
 */
public class InsertSort {
    public static void main(String[] args) {

    }

    private void insertSort(int[] nums) {
        int cons;
        for (int i = 1; i < nums.length; i++) {
            //current len get num
            cons = nums[i];

            //inset into front arr
            for (int j = i; j > 0; j--) {
                if (nums[j] < cons) ;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
