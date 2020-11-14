package com.pattern.factory.demo;

/**
 * Name: CalClient
 * Author: lloydfinch
 * Function: CalClient
 * Date: 2020-10-10 17:56
 * Modify: lloydfinch 2020-10-10 17:56
 */
public class CalClient {
    public static void main(String[] args) {
        String operator = "+";
        CalFactory factory = new ConcreteFactory();
        Calculator calculator = factory.create(operator);
        calculator.setLeftOpt("10");
        calculator.setRightOpt("20");
        String result = calculator.cal();
        System.out.println("result is: " + result);

        String operator2 = "-";
        Calculator calculator1 = factory.create(operator2);
        calculator1.setLeftOpt("10000");
        calculator1.setRightOpt("1010");
        String result2 = calculator1.cal();
        System.out.println("result2 is: " + result2);
    }
}
