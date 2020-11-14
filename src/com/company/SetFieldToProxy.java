package com.company;

import com.company.source.Singleton;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Name: SetFieldToProxy
 * Author: lloydfinch
 * Function: SetFieldToProxy
 * Date: 2020-08-13 14:10
 * Modify: lloydfinch 2020-08-13 14:10
 */
public class SetFieldToProxy {

    public static void main(String[] args) {
        //加载一下便于测试
        {
            AMN.getDefault();
        }

        try {
            test();
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        //获取singleton变量
        Class singleClaz = Class.forName("com.company.source.Singleton");
        Field singleField = singleClaz.getDeclaredField("singleton");
        singleField.setAccessible(true);

        //获取gDefault变量
        Class claz = Class.forName("com.company.SetFieldToProxy$AMN");
        Field gDefaultField = claz.getDeclaredField("gDefault");
        gDefaultField.setAccessible(true);
        //获取gDefault变量的值(Singleton对象的值)
        Object gDefaultValue = gDefaultField.get(null);
        System.out.println("defaultValue: " + gDefaultValue);
        //获取gDefault里面的user的值
        Object singleValue = singleField.get(gDefaultValue); //变量值 = 变量名.get(对象)
        System.out.println("singleValue: " + singleValue);

        System.out.println();
        System.out.println();

        //动态代理前测试
        AMN.getDefault().showInfo();
        String info = AMN.getDefault().getInfo();
        System.out.println("before proxy: " + info);

        System.out.println();
        System.out.println();

        //替换为代理
        Class iClaz = Class.forName("com.company.SetFieldToProxy$IUser");
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{iClaz}, new UserHandler((IUser) singleValue));
        singleField.set(gDefaultValue, proxy); //变量名.set(对象，变量值)

        //动态代理后测试
        AMN.getDefault().showInfo();
        String info1 = AMN.getDefault().getInfo();
        System.out.println("after proxy: " + info1);
    }

    private static class AMN {
        private static final Singleton<IUser> gDefault = new Singleton<IUser>() {
            @Override
            public IUser create() {
                return new User("Java");
            }
        };

        public static IUser getDefault() {
            return gDefault.get();
        }
    }

    /**
     * IUser
     */
    private interface IUser {
        String getInfo();

        void showInfo();
    }

    /**
     * User
     */
    private static class User implements IUser {
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getInfo() {
            return name;
        }

        @Override
        public void showInfo() {
            System.out.println("user name is " + name);
        }
    }

    /**
     * UserHandler (User Proxy)
     */
    private static class UserHandler implements InvocationHandler {

        private IUser user;

        public UserHandler(IUser user) {
            this.user = user;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before invoke: " + method.getName() + "...");
            Object result = method.invoke(user, args);
            System.out.println("after invoke: " + method.getName() + "...");
            return result;
        }
    }
}
