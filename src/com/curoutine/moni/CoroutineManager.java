package com.curoutine.moni;

/**
 * Name: CoroutineManager
 * Author: lloydfinch
 * Function: CoroutineManager
 * Date: 2020-09-03 15:00
 * Modify: lloydfinch 2020-09-03 15:00
 */
public class CoroutineManager {
    public static <T> void execute(CoroutineProducer<T> producer, CoroutineConsumer<T> consumer) {
        while (!producer.isDone()) {
            T product = producer.produce();
            consumer.consume(product);
        }
    }
}
