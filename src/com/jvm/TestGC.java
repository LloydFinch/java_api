package com.jvm;

import java.lang.reflect.Field;

/**
 * Name: TestGC
 * Author: lloydfinch
 * Function: TestGC
 * Date: 2020-08-26 11:00
 * Modify: lloydfinch 2020-08-26 11:00
 */
public class TestGC {
    public static void main(String[] args) {
        System.out.println("before gc: " + System.currentTimeMillis());
        long free1 = Runtime.getRuntime().freeMemory();
        long[] temp = new long[1024 << 10];
        int length = temp.length;
        long free2 = Runtime.getRuntime().freeMemory();
        System.gc();//大概率触发full gc
        System.out.println("after gc: " + System.currentTimeMillis());

        long free3 = Runtime.getRuntime().freeMemory();

        System.out.println("free1: " + free1 + ", free2: " + free2 + ", free3: " + free3);

        System.out.println();
        System.out.println();


        testReflect();
    }

    private static void testFinal() {
        //局部内部类的生命周期比一般的局部变量长
        int a = 10; //默认加了final
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                a = 10; //so，不能修改
                System.out.println(a);// 只能访问
            }
        };
    }


    private static void testReflect() {
        Test test = new Test();
        System.out.println(test.getAge());

        Class aClass = test.getClass();
        try {
            Field age = aClass.getDeclaredField("age");
            age.setAccessible(true);
            age.set(test, 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(test.getAge());
    }

    public static class Test {
        private Integer age = 20;

        public Integer getAge() {
            return age;
        }
    }
}
