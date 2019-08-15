package com.ele.helloword;

import com.ele.helloword.bean.User;
import com.ele.helloword.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWordApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWordApplication.class, args);

        SqlSession session = new SqlSessionFactoryBuilder()
                .build(
                        HelloWordApplication.class.getClassLoader().getResourceAsStream("mybatis-config.xml"))
                .openSession();

        User user = new User("zhangsna", "1232", "13234329399", "北京市昌平区");
        UserDao userDao = session.getMapper(UserDao.class);

        System.out.println(userDao.insertUser(user));

        session.commit();
    }

}
