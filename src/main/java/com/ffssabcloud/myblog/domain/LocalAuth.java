package com.ffssabcloud.myblog.domain;

import java.io.Serializable;

public class LocalAuth implements Auth, Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 123456789L;
    
    private int id;
    private int roleId;
    private String username;
    private transient String password;
    
    public LocalAuth() {}
    public LocalAuth(int roleId, String username, String password) {
        this.roleId = roleId;
        this.username = username;
        this.password = password;
    }
    
    public LocalAuth(int id, int roleId, String username, String password) {
        this(roleId, username, password);
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
