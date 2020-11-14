package com.pattern.factory.demo;

/**
 * Name: CalFactory
 * Author: lloydfinch
 * Function: CalFactory
 * Date: 2020-10-10 17:37
 * Modify: lloydfinch 2020-10-10 17:37
 */
public abstract class CalFactory {
    public abstract Calculator create(String operator);
}
