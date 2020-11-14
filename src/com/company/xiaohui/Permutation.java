package com.company.xiaohui;

/**
 * Name: Permutation
 * Author: lloydfinch
 * Function: Permutation(dict sort)
 * Date: 2020-07-30 15:06
 * Modify: lloydfinch 2020-07-30 15:06
 */
public class Permutation {

    public static void main(String[] args) {
        int[] number = new int[]{5, 1, 3, 2, 4};
        Permutation permutation = new Permutation();

        printArr(number);
        permutation.permutation(number);
        printArr(number);
    }

    /**
     * min number > num
     */
    private int[] permutation(int[] number) {
        if (number == null || number.length == 0) return number;
        int[] result = new int[number.length];
        int minIndex = reverseIndex(number);
        if (minIndex == 0) return result;
        swapIndexHead(number, minIndex);
        reverseAfterIndex(number, minIndex);
        return number;
    }

    /**
     * get reverse index(from end to start)
     */
    private int reverseIndex(int[] number) {
        for (int i = number.length - 1; i > 0; i--) if (number[i] > number[i - 1]) return i;
        return 0;
    }

    /**
     * swap index head and after(> min)
     */
    private void swapIndexHead(int[] number, int index) {
        int head = number[index - 1];
        for (int i = number.length - 1; i >= index; i--) {
            if (number[i] > head) {
                number[index - 1] = number[i];
                number[i] = head;
                break;
            }
        }
    }

    /**
     * sort number after index
     */
    private void reverseAfterIndex(int[] number, int index) {
        for (int i = index, j = number.length - 1; i < j; i++, j--) swap(number, i, j);
    }

    /**
     * swap number
     */
    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private static void printArr(int[] number) {
        for (int i : number) System.out.print(i);
        System.out.println();
    }
}
