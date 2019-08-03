package com.ele.helloword.singleton;

/**
 * 静态内部类实现单例--线程安全
 * 当 Singleton03 类加载时，静态内部类 SingletonHolder 没有被加载进内存。只有当调用getUniqueInstance() 方法从而触发
 * SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，此时初始化INSTANCE实例，并且JVM会确保INSTANCE只被实例化一次
 */
public class Singleton03 {
    private Singleton03() {
    }

    private static class SingletonHolder {
        private static final Singleton03 INSTANCE = new Singleton03();
    }

    public static Singleton03 getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
