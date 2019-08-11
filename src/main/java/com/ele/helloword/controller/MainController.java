package com.ele.helloword.controller;

import com.alibaba.fastjson.JSONObject;
import com.ele.helloword.bean.BaseParam;
import com.ele.helloword.bean.BaseResult;
import com.ele.helloword.bean.RegisterParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/fengniao")
@RestController
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger("MainController.class");

    @ResponseBody
    @RequestMapping("/")
    public String sayHello() {
        String msg = "Welcome, this is hello-world";
        return msg;
    }

    @PostMapping("/register")
    public BaseResult Register(@RequestBody RegisterParam param) {
        String username = param.getUsername();
        if (StringUtils.isEmpty(username)) {
            return new BaseResult(400, "用户名不能为空！");
        }
        String password = param.getPassword();
        if (StringUtils.isEmpty(password)) {
            return new BaseResult(400, "密码不能为空!");
        }
        String verif_code = param.getVerif_code();
        if (StringUtils.isEmpty(verif_code)) {
            return new BaseResult(400, "验证码不能为空或错误！");
        }
        System.out.println(param.toString());
        System.out.println(param.getData());
        // to do ....
        return new BaseResult();
    }

    @RequestMapping("/getdata")
    public BaseResult getData(@RequestBody BaseParam baseParam) {
        JSONObject data = baseParam.getData();
        System.out.println(data);
        return new BaseResult();
    }

}
