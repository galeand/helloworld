package com.ele.helloword;

import com.ele.helloword.bean.User;
import com.ele.helloword.dao.UserDao;
import com.ele.helloword.util.VolatileCachedFactorizer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.math.BigInteger;

@SpringBootApplication
public class HelloWordApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWordApplication.class, args);
    }

}
