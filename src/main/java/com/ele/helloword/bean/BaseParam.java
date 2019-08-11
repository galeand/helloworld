package com.ele.helloword.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BaseParam implements Serializable {
    private static final long serialVersionUID = 1321167338658451592L;

    private JSONObject data;

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
