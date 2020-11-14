package com.pattern.factory.demo;

import java.util.HashMap;

/**
 * Name: ConcreteFactory
 * Author: lloydfinch
 * Function: ConcreteFactory
 * Date: 2020-10-10 17:42
 * Modify: lloydfinch 2020-10-10 17:42
 */
public class ConcreteFactory extends CalFactory {

    private static final HashMap<String, Class<? extends Calculator>> map = new HashMap<>();
    private static final HashMap<String, Calculator> calculatorHashMap = new HashMap<>();

    static {
        map.put(PlusCalculator.OPERATOR, PlusCalculator.class);
        map.put(SubCalculator.OPERATOR, SubCalculator.class);
    }

    @Override
    public Calculator create(String operator) {
        Calculator calculator = null;

        //obtain from cache
        calculator = calculatorHashMap.get(operator);
        if (calculator != null) return calculator;

        //create
        Class<? extends Calculator> aClass = map.get(operator);
        try {
            calculator = aClass.newInstance();
//            Constructor<? extends Calculator> constructor = aClass.getConstructor(String.class);
//            calculator = constructor.newInstance(operator);
            //put into cache
            calculatorHashMap.put(operator, calculator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calculator;
    }
}
