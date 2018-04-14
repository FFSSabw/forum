package com.ffssabcloud.myblog.domain.auth;

import java.io.Serializable;

public class LocalAuth implements Auth, Serializable{

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Integer roleid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}