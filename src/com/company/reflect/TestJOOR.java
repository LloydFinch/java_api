package com.company.reflect;

import com.org.joor.Reflect;

/**
 * Name: TestJOOR
 * Author: lloydfinch
 * Function: TestJOOR
 * Date: 2020-08-14 18:33
 * Modify: lloydfinch 2020-08-14 18:33
 */
public class TestJOOR {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        getClaz();
    }

    private static void getClaz() {
        //get Class
        Reflect r1 = Reflect.onClass(String.class);
        Reflect r2 = Reflect.onClass("java.lang.String");
        Reflect r3 = Reflect.onClass("java.lang.String", ClassLoader.getSystemClassLoader());

        //create object
        Object o1 = Reflect.onClass(Object.class).get();
        Object o2 = Reflect.onClass("java.lang.String").get();
        String s3 = Reflect.on((Object) "hello").get();
        int i4 = Reflect.on(1).get();

        //equals Class.forName();
        Class c5 = Reflect.onClass("java.lang.String").type();

        //constructor
        Test test = new Test();
        Class testClaz = test.getClass();
        //无参构造
        Object obj = Reflect.onClass(testClaz).create().get();
        print(obj);
        //有参构造
        Object obj2 = Reflect.onClass(testClaz).create("android").get();
        print(obj2);

        //执行实例/静态方法
        Reflect reflect = Reflect.onClass(testClaz).create();
        String result = reflect.call("info", "hello").get();
        System.out.println("result: " + result);

        //获取实例/静态字段
        reflect.set("name", "reflect");
        String name = reflect.get("name");
        System.out.println("name: " + name);

        //获取final字段(在Android会报错)
        reflect.set("info", "info");
        String info = reflect.get("info");
        System.out.println("info: " + info);
    }

    public static class Test {
        private String name;
        private final String info = "";

        private Test() {
        }

        public Test(String name) {
            this.name = name;
        }

        private static String info(String text) {
            System.out.println(" : " + text);
            return text;
        }
    }

    public static void print(Object obj) {
        System.out.println("OBJ: " + obj);
    }
}
