package com.company;

/**
 * Name: TestJvm
 * Author: lloydfinch
 * Function: TestJvm
 * Date: 2020-08-05 10:25
 * Modify: lloydfinch 2020-08-05 10:25
 */
public class TestJvm {
    public static void main(String[] args) {
        TestJvm test = new TestJvm();

        test.testIntern();
    }

    private void testStringPlus() {
        String a = null;
        String b = null;
        String c = a + b;
        System.out.println(c);

        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        System.out.println(sb.toString());
    }

    private void testIntern() {
        //intern()常量池已有的字符串
        {
            String a = new String("world");
            String aIntern = a.intern();
            String c = "world";
            System.out.println("a==aIntern? " + (a == aIntern)); //false
            System.out.println("aIntern==c? " + (aIntern == c)); //true
        }

        System.out.println();
        System.out.println();
        System.out.println();

        //intern()常量池没有的字符串
        {
            String a = new String("123") + "456";
            String aIntern = a.intern(); //没有常量"123456"，把a的引用放进去，用来代替常量"123456"，后面可以直接用它来访问
            System.out.println("a==aIntern? " + (a == aIntern)); //true
            String c = "123456"; //这是个a的引用
            System.out.println("a==c? " + (a == c)); //true
            System.out.println("aIntern==c? " + (aIntern == c)); //true

            String d = new String("1") + "23"; //已经有123了，这是个堆引用
            String dIntern = d.intern(); //已经有123了，这是个常量"123"
            System.out.println("d==dIntern " + (d == dIntern)); //false
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }


    private void testString() {
        String hello = "hello";
        String change = changeStr(hello);
        System.out.println(hello);
        System.out.println(change);
    }

    private String changeStr(String source) {
        source += " :plus";
        return source;
    }
}
