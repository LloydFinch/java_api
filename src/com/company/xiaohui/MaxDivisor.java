package com.company.xiaohui;

/**
 * Name: MaxDivisor
 * Author: lloydfinch
 * Function: MaxDivisor，最大公约数
 * Date: 2020-07-20 18:11
 * Modify: lloydfinch 2020-07-20 18:11
 */
public class MaxDivisor {

    public static void main(String[] args) {
        MaxDivisor divisor = new MaxDivisor();
        int num1 = 99999;
        int num2 = 9999;
        int result = divisor.gcd(num1, num2);
        System.out.println(result);
    }

    /**
     * 直接穷举
     */
    public int maxDivisor(int num1, int num2) {
        if (num1 > num2) return maxDivisor(num2, num1);
        int divisor = 1;
        for (int i = 1; i < num1; i++) {
            if (num1 % i == 0 && num2 % i == 0) divisor = Math.max(divisor, i);
        }
        return divisor;
    }

    /**
     * 优化
     * 倒叙遍历，缩小遍历范围
     */
    public int maxDivisor1(int num1, int num2) {
        if (num1 > num2) return maxDivisor1(num2, num1);
        for (int i = num1 / 2; i > 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) return i;
        }
        return 1;
    }

    /**
     * 使用辗转相除法(递归)
     */
    public int maxDivisor2(int num1, int num2) {
        if (num1 > num2) return maxDivisor2(num2, num1);
        if (num2 % num1 == 0) return num1;
        return maxDivisor2(num2 % num1, num1);
    }

    /**
     * 使用辗转相除法(非递归)
     */
    public int maxDivisor3(int num1, int num2) {
        if (num1 > num2) return maxDivisor3(num2, num1);
        int big = num2;
        int small = num1;
        while (big % small != 0) {
            big = big % small;
            small = Math.min(big, small);
            big = Math.max(big, small);
        }
        return small;
    }

    /**
     * 更相减损术(递归)
     * 遍历次数多，但是避免了求余的性能
     */
    public int maxDivisor4(int num1, int num2) {
        if (num1 > num2) return maxDivisor4(num2, num1);
        if (num2 % num1 == 0) return num1;
        return maxDivisor4(num2 - num1, num1);
    }

    /**
     * 最终版本(辗转相除法和更相减损术结合)
     * Tips: 使用num&1==0来判断是否是偶数
     */
    public int gcd(int num1, int num2) {
        if (num1 == num2) return num1;
        if (num1 > num2) return gcd(num2, num1);
        if ((num1 & 1) == 0 && (num2 & 1) == 0) {
            return gcd(num1 >> 1, num2 >> 1) << 1;
        } else if ((num1 & 1) == 0) {
            return gcd(num1 >> 1, num2);
        } else if ((num2 & 1) == 0) {
            return gcd(num1, num2 >> 1);
        } else {
            return gcd(num2 - num1, num1);
        }
    }
}
