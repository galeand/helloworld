package com.ele.helloword.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @name: User
 * @description:
 * @author: xiangyf
 * @create: 2019-08-15 19:13
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7963605663896606976L;
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String address;

    public User(String username, String password, String phone, String address) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public static void printStudents(List<User> studentInfos) {
        System.out.println("[编号]\t\t[用户名]\t\t[密码]\t\t[电话]\t\t[地址]");
        System.out.println("----------------------------------------------------------");
        studentInfos.forEach(s -> System.out.println(s.toString()));
        System.out.println(" ");
    }

    public User(Integer id, String username, String password, String phone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
