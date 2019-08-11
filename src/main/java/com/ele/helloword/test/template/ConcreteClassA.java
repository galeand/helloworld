package com.ele.helloword.test.template;

public class ConcreteClassA extends AbstractClass {
    @Override
    void primitiveMethod1() {
        System.out.println("子类A实现抽象类的主要方法1");
    }

    @Override
    void primitiveMethod2() {
        System.out.println("子类A实现抽象类的主要方法2");
    }
}
