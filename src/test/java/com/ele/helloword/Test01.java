package com.ele.helloword;

import com.ele.helloword.bean.User;
import com.ele.helloword.enums.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * @name: Test01
 * @author: xiangyf
 * @create: 2019-09-30 11:51
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Test01 {


    @Test
    public void test1(){
        for (int i=0; i <= 100; i++){
            int index = (int)(Math.random()*10);
//            System.out.println(index);
            if (!StringUtils.isEmpty(City.getNameByIndex(index))){

                System.out.println(City.getNameByIndex(index)+"人民发来贺电，祝福祖国七十华诞！");
            }
        }
    }

    @Test
    public void test2(){
        User user = new User("张飞", "12345", "14323468239", "河北");
        System.out.println(user);
        testUser(user);
        System.out.println(user);
    }

    public static void testUser(User user){
        user.setAddress("中国");
        user.setId(101);
    }

}
