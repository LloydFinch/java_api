package com.curoutine.moni;

/**
 * Name: SampleProducer
 * Author: lloydfinch
 * Function: SampleProducer
 * Date: 2020-09-03 14:55
 * Modify: lloydfinch 2020-09-03 14:55
 */
public class SampleProducer implements CoroutineProducer<Object> {
    private WhileLoop<Object> loop;

    public SampleProducer() {
        loop = new WhileLoop<Object>() {
            private int otherState;

            @Override
            protected WhileState execute() {
                if (isDone()) return WhileState.BREAK;
                Object calValue = "hello";
                setReturnValue(calValue);
                return WhileState.YIELD;
            }
        };
    }

    @Override
    public Object produce() {
        return loop.loop();
    }

    @Override
    public boolean isDone() {
        return loop.isDone();
    }
}
