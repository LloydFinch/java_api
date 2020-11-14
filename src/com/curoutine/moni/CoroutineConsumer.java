package com.curoutine.moni;

/**
 * Name: CoroutineConsumer
 * Author: lloydfinch
 * Function: CoroutineConsumer
 * Date: 2020-09-03 14:54
 * Modify: lloydfinch 2020-09-03 14:54
 */
public interface CoroutineConsumer<T> {
    public void consume(T t);
}
