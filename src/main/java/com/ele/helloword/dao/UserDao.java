package com.ele.helloword.dao;

import com.ele.helloword.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @name: UserDao
 * @description:
 * @author: xiangyf
 * @create: 2019-08-15 19:12
 */
//@Mapper
public interface UserDao {

    boolean insertUser(User user);

    User selectUser(Integer id);


}
