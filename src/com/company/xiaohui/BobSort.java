package com.company.xiaohui;

/**
 * Name: BobSort
 * Author: lloydfinch
 * Function: BobSort
 * Date: 2020-11-16 11:23
 * Modify: lloydfinch 2020-11-16 11:23
 */
public class BobSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        for (int i : arr) System.out.print(i + " ");
        System.out.println();

        bob4(arr);

        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    /**
     * 使用一个boolean来记录是否有元素交换，如果没有，则代表已有序
     */
    private static void bob2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean swap = false;
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swap = true;
                }
            }
            if (!swap) break;
        }
    }

    private static void bob3(int[] arr) {
        int length = arr.length;
        int lastSwapIndex = 0;
        int sortedBorder = length - 1;
        for (int i = 0; i < length; i++) {
            boolean swap = false;
            for (int j = 0; j < sortedBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;

                    lastSwapIndex = j;
                }
            }
            sortedBorder = lastSwapIndex;
            if (!swap) break;
        }
    }

    private static void bob4(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < (length >>> 1); i++) {
            boolean swap = false;
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swap = true;
                }
            }

            if (!swap) break;

            swap = false;
            for (int j = length - 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swap = true;
                }
            }

            if (!swap) break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }


}
