package com.ele.helloword;

import java.lang.reflect.Method;

/**
 * @name: InvokeTests
 * @author: xiangyf
 * @create: 2019-10-01 19:13
 * @description:
 */
public class InvokeTests {

    public int add(int a, int b){
        return a + b;
    }

    public String echo(String msg){
        return msg;
    }

    public static void main(String[] args) throws Exception {
        //测试java类的反射
        Class classObject = InvokeTests.class;
        Object clazz = classObject.newInstance();

        Method addMethod = classObject.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(clazz, 100, 200);
        System.out.println(result);

        Method echoMethod = classObject.getMethod("echo", String.class);
        Object result2 = echoMethod.invoke(clazz, "你好，中国");
        System.out.println(result2);

    }
}
