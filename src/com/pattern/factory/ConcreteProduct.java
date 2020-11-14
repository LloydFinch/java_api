package com.pattern.factory;

/**
 * Name: ConcreteProduct
 * Author: lloydfinch
 * Function: ConcreteProduct
 * Date: 2020-10-10 17:31
 * Modify: lloydfinch 2020-10-10 17:31
 */
public class ConcreteProduct extends Product {
    private String name;

    public ConcreteProduct() {
    }

    public ConcreteProduct(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ConcreteProduct{" +
                "name='" + name + '\'' +
                '}';
    }
}
