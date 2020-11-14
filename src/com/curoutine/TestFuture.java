package com.curoutine;

import com.curoutine.moni.DataImpl;
import com.curoutine.moni.IData;

import java.util.concurrent.*;

/**
 * Name: TestFuture
 * Author: lloydfinch
 * Function: TestFuture
 * Date: 2020-08-27 18:36
 * Modify: lloydfinch 2020-08-27 18:36
 */
public class TestFuture {
    public static void main(String[] args) {
        Callback callback = data -> println("get data: " + data.getResult());
        request(callback);
    }

    private static void request(Callback callback) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.allowCoreThreadTimeOut(true);
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        Task task = new Task(callback);
        Future<IData> future = executor.submit(task);
        try {
            println("Thread: " + Thread.currentThread().getName());
            println("run before future");
            IData data = future.get();//会阻塞当前线程
            println("run after future");
            callback.onResult(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Task implements Callable<IData> {
        private Callback callback;

        public Task(Callback callback) {
            this.callback = callback;
        }

        @Override
        public IData call() throws Exception {
            println(Thread.currentThread().getName());
            Thread.sleep(1000);
            return new DataImpl();
        }
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static interface Callback {
        void onResult(IData data);
    }

}
