package com.company.xiaohui;

/**
 * Name: IsPower
 * Author: lloydfinch
 * Function: IsPower
 * Date: 2020-07-21 11:27
 * Modify: lloydfinch 2020-07-21 11:27
 */
public class IsPower {

    public static void main(String[] args) {
        IsPower isPower = new IsPower();
        int num = 16;
        boolean power = isPower.isPower3(num);
        System.out.println(num + " is power: " + power);
    }

    /**
     * 乘比
     */
    public boolean isPower(int num) {
        int power = 1;
        while (power <= num) {
            if (power == num) return true;
            power <<= 1;
        }
        return false;
    }

    /**
     * 除比
     */
    public boolean isPower2(int num) {
        int power = num;
        while (power > 1) {
            if (power % 2 != 0) return false;
            power >>= 1;
        }
        return true;
    }

    /**
     * 相与
     * 幂只有末尾是0，其他是1，减1后各个位置都是1
     */
    public boolean isPower3(int num) {
        return (num & (num - 1)) == 0;
    }
}
