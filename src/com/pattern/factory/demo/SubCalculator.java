package com.pattern.factory.demo;

/**
 * Name: SubCalculator
 * Author: lloydfinch
 * Function: SubCalculator
 * Date: 2020-10-10 18:01
 * Modify: lloydfinch 2020-10-10 18:01
 */
public class SubCalculator extends Calculator {
    public static String OPERATOR = "-";

    public SubCalculator() {
        super();
        this.operator = OPERATOR;
    }

    @Override
    public String calculate() {
        return String.valueOf(Integer.parseInt(leftOpt) - Integer.parseInt(rightOpt));
    }
}
