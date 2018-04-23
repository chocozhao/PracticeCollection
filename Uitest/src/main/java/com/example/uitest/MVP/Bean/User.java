package com.example.uitest.MVP.Bean;

/**
 * Created by chocozhao on 2018/3/22.
 * 用户实体类
 */

public class User {
    private String username ;
    private String password ;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
