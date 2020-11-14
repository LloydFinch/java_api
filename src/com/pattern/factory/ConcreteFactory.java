package com.pattern.factory;

/**
 * Name: ConcreteFactory
 * Author: lloydfinch
 * Function: ConcreteFactory
 * Date: 2020-10-10 17:31
 * Modify: lloydfinch 2020-10-10 17:31
 */
public class ConcreteFactory extends Factory {
    @Override
    public <T extends Product> T create(Class<T> claz) {
        Product product = null;
        try {
//            product = claz.newInstance();
            product = (Product) Class.forName(claz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
