package com.company;

/**
 * Name: TestClass
 * Author: lloydfinch
 * Function: TestClass
 * Date: 2020-07-29 18:41
 * Modify: lloydfinch 2020-07-29 18:41
 */
public class TestClass {

    public static void main(String[] args) {
        A a = new A();
//        Base base = new Child();
        a.print(new Child());
    }

    static class Base {
        public void info() {
            System.out.println("Base info");
        }
    }

    static class Child extends Base {
        @Override
        public void info() {
            System.out.println("Child info");
        }
    }

    /**
     * 重载(外观类型)
     */
    static class A {
        public void print(Child child) {
            System.out.println("print child");
        }

        public void print(Base base) {
            base.info();
            System.out.println("print base");
        }
    }

}
