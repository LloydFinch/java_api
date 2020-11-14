package com.pattern.factory;

/**
 * Name: Client
 * Author: lloydfinch
 * Function: Client
 * Date: 2020-10-10 17:33
 * Modify: lloydfinch 2020-10-10 17:33
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        ConcreteProduct product = factory.create(ConcreteProduct.class);
        product.setName("product");
        System.out.println(product);
    }
}
