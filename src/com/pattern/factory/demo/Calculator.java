package com.pattern.factory.demo;

/**
 * Name: Calculator
 * Author: lloydfinch
 * Function: Calculator
 * Date: 2020-10-10 17:37
 * Modify: lloydfinch 2020-10-10 17:37
 */
public abstract class Calculator {
    protected String leftOpt;
    protected String rightOpt;
    protected String operator;

    public Calculator() {
    }

    public Calculator(String operator) {
        this.operator = operator;
    }

    public String getLeftOpt() {
        return leftOpt;
    }

    public void setLeftOpt(String leftOpt) {
        this.leftOpt = leftOpt;
    }

    public String getRightOpt() {
        return rightOpt;
    }

    public void setRightOpt(String rightOpt) {
        this.rightOpt = rightOpt;
    }

    public String getOperator() {
        return operator;
    }

    public String cal() {
        String result = calculate();
        clear();
        return result;
    }

    protected abstract String calculate();

    private void clear() {
        leftOpt = null;
        rightOpt = null;
    }
}
