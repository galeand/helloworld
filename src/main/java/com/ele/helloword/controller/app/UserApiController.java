package com.ele.helloword.controller.app;

import com.alibaba.fastjson.JSONObject;
import com.ele.helloword.bean.BaseParam;
import com.ele.helloword.bean.BaseResult;
import com.ele.helloword.service.app.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @name: UserApiController
 * @description:
 * @author: xiangyf
 * @create: 2019-08-10 21:27
 */
@RequestMapping("/userapi")
@RestController
public class UserApiController {
    private static final Logger logger = LoggerFactory.getLogger("UserApi.class");
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public BaseResult index() {
        return new BaseResult("index");
    }

    @RequestMapping("/login")
    public BaseResult login(@RequestBody BaseParam baseParam) {
//        JSONObject data1 = baseParam.getData();
//        System.out.println(data1);
        // to get data from baseParam
        Map<String, Object> paramMap = null;
        try {
            paramMap = userService.getParamFromRequestBody(baseParam);
        } catch (Exception e) {
            e.printStackTrace();
//            return new BaseResult(400, e.getMessage());
        }
        logger.info("{}::{}--{}", this.getClass().getName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                paramMap);
        // to  do with param
        String data = userService.login(paramMap);
        return new BaseResult(data);
    }

    @RequestMapping("/logout")
    public BaseResult logout(@RequestBody BaseParam baseParam) {
        // to get data from baseParam
        // to  do with param
        String data = null;
        return new BaseResult(data);
    }


}
