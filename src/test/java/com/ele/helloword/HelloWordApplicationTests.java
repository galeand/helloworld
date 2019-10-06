package com.ele.helloword;

import com.ele.helloword.bean.User;
import com.ele.helloword.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class HelloWordApplicationTests {


    @Test
    public void contextLoads() {
        SqlSession session = new SqlSessionFactoryBuilder()
                .build(
                        HelloWordApplicationTests.class.getClassLoader().getResourceAsStream("mybatis-config.xml"))
                .openSession();

        User user = new User("zhangsna", "1232", "13234329399", "北京市昌平区");
        UserDao userDao = session.getMapper(UserDao.class);

        System.out.println(userDao.insertUser(user));

        session.commit();
    }

}
