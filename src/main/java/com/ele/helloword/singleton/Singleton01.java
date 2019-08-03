package com.ele.helloword.singleton;

/**
 * 懒汉式实现单例--线程不安全
 * 私有静态变量 uniqueInstance 被延迟实例化，这样做的好处是，如果没有用到该类
 * 该类，那么就不会实例化 uniqueInstance，从而节约资源。
 *
 * 这个实现在多线程环境下是不安全的，如果多个线程能够同时进入
 * if (uniqueInstance == null) ，并且此时 uniqueInstance 为 null，那么会有多个线程执
 * 行 uniqueInstance = new Singleton(); 语句，这将导致实例化多次
 * uniqueInstance
 */
public class Singleton01 {
    private static Singleton01 uniqueInstance;

    private Singleton01() {

    }

    public static Singleton01 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton01();
        }
        return uniqueInstance;
    }
}
