package com.exam;

/**
 * Name: Genera
 * Author: lloydfinch
 * Function: Genera
 * Date: 2020-08-26 16:18
 * Modify: lloydfinch 2020-08-26 16:18
 */
public class Genera {
    public static void main(StringTest[] args) {

        {
            //数组是协变的
//        Object[] arr = new String[10];
            //泛型是无关的
//        List<Object> list = new ArrayList<String>();
        }

        //泛型检查是针对引用的，而不是实际对象
        {
//            List<Integer> list = new ArrayList<>();
//            List list1 = new ArrayList<Integer>();
//            list.add(1);
//            list1.add("");
//            Integer integer = list.get(1);
        }
    }


//    public void func1(List<String> list) {
//
//    }
//
//    public void func1(List<Integer> list) {
//
//    }

    public void func2(StringTest[] str) {

    }

    public void func2(Integer[] ints) {

    }

    public static class Test<T extends T2 & I1> {

    }

    public static class T2 {

    }

    public static class T3 {

    }

    public static interface I1 {

    }

}
