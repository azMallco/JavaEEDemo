package com.lujiahao.vo;

/**
 * Created by lujiahao on 2016/12/5.
 */
public class User {
    private String username;
    private String userpwd;

    public User(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
