package com.ele.helloword.test.singleton;

/**
 * 双重校验锁实现单例--线程安全
 * uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那
 * 部分的代码进行，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。
 * uniqueInstance 没有被实例化时，才需要进行加锁。
 * 双重校验锁先判断 uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化
 * uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化
 * 语句进行加锁。
 */
public class Singleton02 {
    /**
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
     */
    private volatile static Singleton02 uniqueInstance;

    private Singleton02() {

    }

    public static Singleton02 getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton02.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton02();
                }
            }
        }
        return uniqueInstance;
    }
}
