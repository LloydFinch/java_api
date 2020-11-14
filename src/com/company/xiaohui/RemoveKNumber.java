package com.company.xiaohui;

/**
 * Name: RemoveKNumber
 * Author: lloydfinch
 * Function: RemoveKNumber(greed)
 * Date: 2020-07-30 16:29
 * Modify: lloydfinch 2020-07-30 16:29
 */
public class RemoveKNumber {
    public static void main(String[] args) {
        RemoveKNumber removeKNumber = new RemoveKNumber();
        String number = "11110";

        String result = removeKNumber.removeKNumber2(number, 3);
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println(number);
        System.out.println(result);
    }

    /**
     * rude
     */
    public String removeKNumber(String number, int k) {
        if (number == null) return number;
        String value = number;
        int len = 0;
        while (len != k) {
            if (value.length() == 0) break;
            boolean hasCut = false;
            for (int i = 0; i < value.length() - 1; i++) {
                if (value.charAt(i) > value.charAt(i + 1)) {
                    value = value.replaceFirst(String.valueOf(value.charAt(i)), "");
                    len++;
                    hasCut = true;
                    System.out.println("in for " + value);
                    break;
                }
            }

            //no break, remove right
            if (!hasCut) {
                value = value.replaceFirst(String.valueOf(value.charAt(value.length() - 1)), "");
                System.out.println("out for " + value);
                len++;
            }
        }

        //remove '0'
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != '0') break;
            value = value.replaceFirst(String.valueOf(value.charAt(i)), "");
        }
        if ("".equals(value)) value = "0";

        return value;
    }

    /**
     * elegant
     */
    public String removeKNumber2(String number, int k) {
        if (number == null) return number;
        int realLength = number.length() - k;
        int top = 0;
        char[] chars = new char[number.length()];
        for (int i = 0; i < chars.length; i++) {
            char c = number.charAt(i);
            while (top > 0 && chars[top - 1] > c && k > 0) {
                k--;
                top--;
            }
            chars[top++] = c;
        }
        int offset = 0;
        while (offset < realLength && chars[offset] == '0') {
            offset++;
        }

        if (offset == realLength) return "0";
        return new String(chars, offset, realLength - offset);
    }
}
