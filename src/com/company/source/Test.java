package com.company.source;

/**
 * Name: Test
 * Author: lloydfinch
 * Function: Test
 * Date: 2020-08-12 09:57
 * Modify: lloydfinch 2020-08-12 09:57
 */
public class Test {
    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder(10);
        sb.append("hello");
        sb.append("world");
        sb.append("android");
        System.out.println(sb.toString());

//
//        Singleton<UserSingleton> user = new Singleton<UserSingleton>() {
//            @Override
//            public UserSingleton create() {
//                return new UserSingleton();
//            }
//        };
//
//        UserSingleton userSingleton = user.get();
//        System.out.println(userSingleton);
    }

    public static class UserSingleton {
    }
}
