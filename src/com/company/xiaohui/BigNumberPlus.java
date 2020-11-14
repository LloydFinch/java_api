package com.company.xiaohui;

/**
 * Name: BigNumberPlus
 * Author: lloydfinch
 * Function: BigNumberPlus
 * Date: 2020-07-31 18:32
 * Modify: lloydfinch 2020-07-31 18:32
 */
public class BigNumberPlus {
    public static void main(String[] args) {
        String a = "12388592438590438593";
        String b = "345768653345455";
        String result = bigPlus(a, b);
        System.out.println(result);
    }


    public static String bigPlus(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? a.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? b.charAt(l2) - '0' : 0;

            int sum = n1 + n2 + carry;
            int res = sum % 10;
            sb.append(res);
            carry = sum / 10;

            l1--;
            l2--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }


    public static void printArr(int[] arr) {
        for (int i : arr) System.out.print(i);
        System.out.println();
    }
}
