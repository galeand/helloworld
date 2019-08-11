package com.ele.helloword.test.factory;

import com.ele.helloword.domain.Product;

/**
 * 在工厂方法中，是由子类来创建对象,
 * Factory 有一个 doSomething() 方法，这个方法需要用到一个产品对象，
 * 这个产品 对象由 factoryMethod() 方法创建。该方法是抽象的，需要由子类去实现。
 */
public abstract class Factory {
    abstract public Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();
        // to do
    }
}

class ConcreteFactory1 extends Factory {

    @Override
    public Product factoryMethod() {
        Product product = new Product();
        // to do something with product
        return product;
    }
}

class ConcreteFactory2 extends Factory {

    @Override
    public Product factoryMethod() {
        Product product = new Product();
        // to do something with product
        return product;
    }
}

