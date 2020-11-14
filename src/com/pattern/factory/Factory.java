package com.pattern.factory;

/**
 * Name: Factory
 * Author: lloydfinch
 * Function: Factory
 * Date: 2020-10-10 17:29
 * Modify: lloydfinch 2020-10-10 17:29
 */
public abstract class Factory {
    public abstract <T extends Product> T create(Class<T> claz);
}
