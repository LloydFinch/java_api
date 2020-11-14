package com.company.xiaohui;

/**
 * Name: Test
 * Author: lloydfinch
 * Function: Test
 * Date: 2020-08-14 10:40
 * Modify: lloydfinch 2020-08-14 10:40
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 8, 9, 10, 3, 4, 2, 1, 3};
        printArr(arr);
        quick(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void quick(int[] arr, int left, int right) {
        //递归终止条件
        if (left >= right) return;

        //处理当前层逻辑
        int start = left;
        int end = right;
        int pivot = arr[start];

        while (start != end) {
            while (arr[end] > pivot && end > start) end--;
            while (arr[start] <= pivot && start < end) start++;
            if (start < end) {
                swap(arr, start, end);
            }
        }

        //条件更新
        swap(arr, start, left);

        //处理下一层
        quick(arr, left, start - 1);
        quick(arr, start + 1, right);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
