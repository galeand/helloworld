package com.ele.helloword.service.app;

import com.alibaba.fastjson.JSONObject;
import com.ele.helloword.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @name: UserService
 * @description:
 * @author: xiangyf
 * @create: 2019-08-11 20:25
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger("UserService.class");

    public Map<String, Object> getParamFromRequestBody(BaseParam baseParam) throws Exception {
        Map<String, Object> res = new HashMap<>();
        JSONObject data = baseParam.getData();
        if (StringUtils.isEmpty(data)) {
            throw new Exception("前端传过来的参数为空！");
        }
        data.forEach(res::put);
        // to do ...

        return res;
    }

    public String login(Map<String, Object> param) {
        // to do ...

        return "";
    }
}
