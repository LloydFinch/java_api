package com.exam;

/**
 * Name: String
 * Author: lloydfinch
 * Function: String
 * Date: 2020-10-13 09:21
 * Modify: lloydfinch 2020-10-13 09:21
 */
public class StringTest {

    public static void main(String[] args) {
        String hello = new String("hello");
        String aHello = hello.intern();
        String iHello = "hello";
        System.out.println("hello==aHello: " + (hello == aHello));
        System.out.println("hello==iHello:" + (hello == iHello));
        System.out.println("aHello==iHello:" + (aHello == iHello));

        System.out.println(hello.hashCode());
        System.out.println(aHello.hashCode());
        System.out.println(iHello.hashCode());
    }

}
