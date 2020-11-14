package com.company.reflect;

import java.lang.reflect.*;

/**
 * Name: LReflect
 * Author: lloydfinch
 * Function: LReflect，对反射的封装
 * Date: 2020-08-17 15:51
 * Modify: lloydfinch 2020-08-17 15:51
 */
public class LReflect {

    /**
     * create a object
     *
     * @param className class canonical name
     * @param pareTypes constructor params type
     * @param params    constructor params value
     * @return object
     */
    public static Object createObject(String className, Class[] pareTypes, Object[] params) {
        try {
            Class claz = Class.forName(className);
            Constructor ctor = claz.getDeclaredConstructor(pareTypes);
            ctor.setAccessible(true);
            return ctor.newInstance(params).getClass().getCanonicalName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * invoke method of instance
     *
     * @param obj        the object the method invoke from
     * @param methodName method name
     * @param pareTypes  method params type
     * @param params     method params value
     * @return the result of the method invoke
     */
    public static Object invokeInstanceMethod(Object obj, String methodName, Class[] pareTypes, Object[] params) {
        if (obj == null) return null;
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, pareTypes);
            method.setAccessible(true);
            method.invoke(obj, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * invoke static method
     *
     * @param className
     * @param methodName
     * @param pareTypes
     * @param params
     * @return
     */
    public static Object invokeClassMethod(String className, String methodName, Class[] pareTypes, Object[] params) {
        try {
            Class claz = Class.forName(className);
            Method method = claz.getDeclaredMethod(methodName, pareTypes);
            method.setAccessible(true);
            return method.invoke(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getField(String className, Object obj, String fieldName) {
        try {
            Class claz = Class.forName(className);
            Field field = claz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setField(String className, Object obj, String fieldName, Object filedValue) {
        try {
            Class claz = Class.forName(className);
            Field field = claz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, filedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{H.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }

    interface H {
        void info();
    }
}
