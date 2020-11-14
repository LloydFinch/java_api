package com.curoutine.moni;

/**
 * Name: CoroutineProducer
 * Author: lloydfinch
 * Function: CoroutineProducer
 * Date: 2020-09-03 14:54
 * Modify: lloydfinch 2020-09-03 14:54
 */
public interface CoroutineProducer<T> {
    public T produce();

    public boolean isDone();
}
