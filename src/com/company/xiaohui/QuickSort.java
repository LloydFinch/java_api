package com.company.xiaohui;

/**
 * Name: QuickSort
 * Author: lloydfinch
 * Function: QuickSort
 * Date: 2020-07-21 15:49
 * Modify: lloydfinch 2020-07-21 15:49
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] num = new int[]{2, 4, 5, 6, 8, 9, 1, 10, 3, 7, 0, 11};
        quickSort.printArr(num);
        System.out.println();
        quickSort.sort(num);
        quickSort.printArr(num);
    }

    public void sort(int[] nums) {
        sort1(nums, 0, nums.length - 1);
    }

    public void sort1(int[] num, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        //get pivot
        int pivot = pivot(num, start, end);
        //right to left
        while (left != right) {
            while (num[right] > pivot && right > left) right--;
            //left to right (Tips: <= not <)
            while (num[left] <= pivot && left < right) left++;
            //swap left and right
            if (left < right) swap(num, left, right);
        }
        //swap pivot
        swap(num, start, left);
        //sort left part
        sort1(num, start, left - 1);
        //sort right part
        sort1(num, left + 1, end);
    }

    /**
     * 获取pivot
     */
    public int pivot(int[] num, int start, int end) {
        return num[start];
    }

    public void swap(int[] num, int index1, int index2) {
        int temp = num[index1];
        num[index1] = num[index2];
        num[index2] = temp;
    }

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void print(String a) {
        System.out.println(a);
    }
}
