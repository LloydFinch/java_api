package com.company;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Name: ClassSize
 * Author: lloydfinch
 * Function: ClassSize
 * Date: 2020-08-07 14:53
 * Modify: lloydfinch 2020-08-07 14:53
 */
public class ClassSize {
    private static Unsafe UNSAFE;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void classMemInfo(Class claz) {
        Field[] declaredFields = claz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " -- " + UNSAFE.objectFieldOffset(declaredField));
        }
    }

    private static class ObjectA {
        String str;   // 4
        int i1;       // 4
        byte b1;      // 1
        byte b2;      // 1
        int i2;       // 4
        ObjectB obj;  //4
        byte b3;      // 1
    }

    private static class ObjectB {
    }

    public static void main(String[] args) {
        classMemInfo(ObjectA.class);
    }
}
