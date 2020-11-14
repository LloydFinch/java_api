package com.company;

/**
 * Name: TestEnum
 * Author: lloydfinch
 * Function: TestEnum
 * Date: 2020-10-26 15:57
 * Modify: lloydfinch 2020-10-26 15:57
 */
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(State.DESTROYED.ordinal());
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }
}
