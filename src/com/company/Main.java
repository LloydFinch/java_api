package com.company;


import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        Print printer = new Log();
        LogHandler logHandler = new LogHandler(printer);

        Print proxy = (Print) Proxy.newProxyInstance(Print.class.getClassLoader(), new Class[]{Print.class}, logHandler);
        proxy.println();
    }


    public interface Print {
        void println();

        void test2();
    }

    public static class Log implements Print {
        @Override
        public void println() {
            System.out.println("println in Log");
        }

        @Override
        public void test2() {
            System.out.println("test2");
        }
    }

    public static class LogHandler implements InvocationHandler {

        private Print log;

        LogHandler(Print log) {
            this.log = log;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("proxy class name:" + proxy.getClass().getName());
//            System.out.println("log class name:" + log.getClass().getName());
//            System.out.println("before invoke");
//
//            System.out.println(proxy.getClass().getName());
//            byte[] b = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(), proxy.getClass().getInterfaces());
//            FileOutputStream out = new FileOutputStream("./" + proxy.getClass().getSimpleName() + ".class");
//            out.write(b);
//            out.flush();
//            out.close();
//
//            Object result = method.invoke(log, args);
//            System.out.println("after invoke");
            return null;
        }
    }
}
