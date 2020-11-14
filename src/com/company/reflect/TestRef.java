package com.company.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * Name: TestRef
 * Author: lloydfinch
 * Function: TestRef
 * Date: 2020-09-07 14:31
 * Modify: lloydfinch 2020-09-07 14:31
 */
public class TestRef {

    public static void main(String[] args) throws NoSuchFieldException {
        Call<Integer> call = new Call();
        TypeVariable[] typeParameters = call.getClass().getTypeParameters();
        for (TypeVariable typeParameter : typeParameters) {
            System.out.println(Arrays.toString(typeParameter.getBounds()));
            System.out.println(typeParameter.getTypeName());
        }

        System.out.println();

        Field call1 = User.class.getDeclaredField("call");
        call1.setAccessible(true);
        System.out.println(call1.getGenericType());
    }


    public static class User {
        private Call<Integer> call;
    }

    public static class Call<T extends Number> {

    }
}
