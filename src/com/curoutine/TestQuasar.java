package com.curoutine;

//import co.paralleluniverse.fibers.Fiber;
//import co.paralleluniverse.fibers.SuspendExecution;

import java.lang.reflect.Method;

/**
 * Name: TestQuasar
 * Author: lloydfinch
 * Function: TestQuasar
 * Date: 2020-08-25 18:15
 * Modify: lloydfinch 2020-08-25 18:15
 */
public class TestQuasar {
    public static void main(String[] args) {
//        Fiber fiber = new Fiber() {
//            @Override
//            protected Object run() throws SuspendExecution, InterruptedException {
//                System.out.println("run in fiber");
//                return super.run();
//            }
//        };
//        Fiber start = fiber.start();
    }

    public @interface TT {

    }

    public static void println(Object obj) {
        System.out.println(obj);
    }
}
