package com.lujiahao.domain;
/**
 * 用户信息的Bean
 * Created by lujiahao
 * Created at 2016/6/24 17:14
 */
public class User {
    private String id;
    private String username;
    private String password;
    private String gender;
    private String age;// 因为服务器传过来的数据都是string类型的

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
