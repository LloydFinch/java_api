package com.curoutine.moni;

/**
 * Name: WhileLoop
 * Author: lloydfinch
 * Function: WhileLoop
 * Date: 2020-09-03 14:50
 * Modify: lloydfinch 2020-09-03 14:50
 */
public abstract class WhileLoop<T> {
    private boolean isDone;
    private T rVal;

    public boolean isDone() {
        return isDone;
    }

    protected void setReturnValue(T val) {
        rVal = val;
    }

    public T getReturnValue() {
        return rVal;
    }

    public T loop() {
        while (true) {
            WhileState state = execute();
            if (state == WhileState.YIELD) return getReturnValue();
            else if (state == WhileState.BREAK) {
                isDone = true;
                return null;
            }
        }
    }

    protected abstract WhileState execute();
}
