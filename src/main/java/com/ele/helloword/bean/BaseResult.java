package com.ele.helloword.bean;

import java.io.Serializable;

public class BaseResult implements Serializable {

    /**
     * 建议用户自定义一个serialVersionUID,因为默认的serialVersinUID对于class的细节非常敏感，反序列化时可能会导致InvalidClassException这个异常
     */
    private static final long serialVersionUID = -5893998480701501004L;

    private Boolean success;
    private Integer code;
    private String message;

    public BaseResult() {
        this.success = true;
        this.code = 200;
        this.message = "success";
    }

    public BaseResult(Integer code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
