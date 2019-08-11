package com.ele.helloword.test.template;

/**
 * 抽象模板类，用来定义算法的基本骨架，同时定义一个或多个抽象操作，这些操作由子类进行实现
 */
public abstract class AbstractClass {
    abstract void primitiveMethod1();

    abstract void primitiveMethod2();

    public void execute() {
        primitiveMethod1();
        primitiveMethod2();
    }
}
