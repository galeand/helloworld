package com.ele.helloword;

import com.ele.helloword.bean.User;
import com.ele.helloword.service.alipay.AddressService;
import com.ele.helloword.util.VolatileCachedFactorizer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @name: Test01
 * @author: xiangyf
 * @create: 2019-08-31 17:09
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWordApplication.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Test01 {
//    @Autowired
//    private VolatileCachedFactorizer volatileCachedFactorizer;

    @Autowired
    private AddressService addressService;

    @Test
    public void test03(){
        System.out.println(addressService.add(4,7));
    }

//    @Test
//    public void test02(){
//        BigInteger k = new BigInteger("8900");
//        Integer[] factor = volatileCachedFactorizer.doFactorizer(k);
//        System.out.println(factor);
//    }

    @Test
    public void test01() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(12, "张三", "asd123", "13243539399", "重庆市开州区"));
        userList.add(new User(14, "李四", "asd123", "13243539391", "重庆市开州区"));
        userList.add(new User(20, "王五", "asd123", "13243539395", "重庆市开州区"));
        userList.add(new User(31, "孙六", "asd123", "13243539392", "重庆市开州区"));
        userList.add(new User(37, "赵七", "asd123", "13243539398", "重庆市开州区"));
        userList.add(new User(50, "王八", "asd123", "13243539390", "重庆市开州区"));

        List<User> list1 = userList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        System.out.println("==========按照id升序排序==============");
        User.printStudents(list1);


        System.out.println("==========按照电话号码升序排序==========");
        List<User> list2 = userList.stream().sorted(Comparator.comparing(User::getPhone)).collect(Collectors.toList());
        User.printStudents(list2);
    }
}
