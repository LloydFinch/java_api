package com.pattern.factory.demo;

/**
 * Name: PlusCalculator
 * Author: lloydfinch
 * Function: PlusCalculator
 * Date: 2020-10-10 17:40
 * Modify: lloydfinch 2020-10-10 17:40
 */
public class PlusCalculator extends Calculator {

    public static String OPERATOR = "+";

    public PlusCalculator() {
        super();
        this.operator = OPERATOR;
    }

    @Override
    public String calculate() {
        return plus();
    }

    private String plus() {
        return String.valueOf(Integer.parseInt(leftOpt) + Integer.parseInt(rightOpt));
    }
}
