package com.ele.helloword.bean;

import java.io.Serializable;

public class RegisterParam extends BaseParam implements Serializable {

    private static final long serialVersionUID = 6970243373270725904L;

    private String username;
    private String password;
    private String verif_code;

    @Override
    public String toString() {
        return "RegisterParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verif_code='" + verif_code + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerif_code() {
        return verif_code;
    }

    public void setVerif_code(String verif_code) {
        this.verif_code = verif_code;
    }
}
