package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Name: TestReflection
 * Author: lloydfinch
 * Function: TestReflection
 * Date: 2020-08-08 13:44
 * Modify: lloydfinch 2020-08-08 13:44
 */
public class TestReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
//        getConstructors();
//        getField();

        getFieldPra();
    }

    /**
     * getClass three way
     */
    private static void getClassT() throws ClassNotFoundException {
        Class claz1 = Boolean.TYPE;

        Class claz2 = String.class;

        String str = "hello";
        Class claz3 = str.getClass();

        Class claz4 = Class.forName("java.lang.String");
    }

    private static void getConstructors() {
        Class claz = TestClass.class;
        Constructor[] constructors = claz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println();

        Constructor[] declaredConstructors = claz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
    }

    private static void getField() throws NoSuchFieldException, IllegalAccessException {
        TestClass testClass = new TestClass("Android");
        Class<? extends TestClass> aClass = testClass.getClass();

        //get static
        {
            Field tag = aClass.getDeclaredField("TAG");
            System.out.println(tag);
            tag.setAccessible(true);
            Object tagValue = tag.get(null);//static variable can use null
            System.out.println(tagValue);
        }

        //get non-static
        {
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println(name.getName());
            Object nameValue = name.get(testClass); //non-static variable need a instance
            System.out.println(nameValue);
        }
    }

    private static void getFieldPra() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取Ins里面的sin
        Class insClass = Class.forName("com.company.TestReflection$Ins");
        Field sinField = insClass.getDeclaredField("sin");
        sinField.setAccessible(true);

        //获取Practice里面的ins成员
        Class praClass = Class.forName("com.company.TestReflection$Practice");
        Field insField = praClass.getDeclaredField("ins");
        insField.setAccessible(true);

        //获取ins的值，因为是static的，所以不需要接收者
        Object insValue = insField.get(null);
        System.out.println("insValue: " + insValue);

        //获取ins里面的sin的值
        Object insSinValue = sinField.get(insValue);
        System.out.println("insSinValue: " + insSinValue);

        //获取ins里面的sin里面的name
        Class sinClass = Class.forName("com.company.TestReflection$Sin");
        Field sinNameField = sinClass.getDeclaredField("name");
        sinNameField.setAccessible(true);
        Object sinNameValue = sinNameField.get(insSinValue);
        System.out.println(sinNameValue);
    }

    public static class TestClass {
        private static String TAG = "TestClass";
        private String name;

        public TestClass() {
        }

        public TestClass(String name) {
            this.name = name;
        }

        private TestClass(int a, int b) {

        }
    }

    public static class Practice {
        private static final Ins ins = new Ins() {
            @Override
            public Sin create() {
                return new Sin("Android");
            }
        };

        static {
            ins.get();
        }
    }

    public static abstract class Ins {
        private Sin sin;

        public abstract Sin create();

        public Sin get() {
            if (sin == null) {
                sin = create();
            }
            return sin;
        }
    }

    public static class Sin {
        private String name;

        public Sin(String name) {
            this.name = name;
        }
    }

}
