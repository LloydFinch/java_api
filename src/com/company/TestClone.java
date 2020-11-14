package com.company;

/**
 * Name: TestClone
 * Author: lloydfinch
 * Function: TestClone
 * Date: 2020-09-18 14:24
 * Modify: lloydfinch 2020-09-18 14:24
 */
public class TestClone {

    public static class Doc implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
