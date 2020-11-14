package com.company.source;

/**
 * Name: Singleton
 * Author: lloydfinch
 * Function: Singleton
 * Date: 2020-08-12 09:53
 * Modify: lloydfinch 2020-08-12 09:53
 */
public abstract class Singleton<T> {

    private T singleton;

    public abstract T create();

    public final T get() {
        if (singleton == null) {
            //这里的锁对象记得是this，而不是Singleton.class
            //因为创建Singleton是不需要同步的，获取才是需要同步的，而获取都是通过Singleton的
            synchronized (this) {
                if (singleton == null) {
                    singleton = create();
                }
            }
        }
        return singleton;
    }
}
