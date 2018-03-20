package com.ffssabcloud.myblog.domain.auth;

import java.io.Serializable;

public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String username;
    private String description;
    private String location;
    /**
     * 记录注册类型
     * e.g LOCAL WEIBO 
     */
    private String registerBy;
    private Auth auth;
    
    public User() {}
    
    public User(String username, String registerBy) {
        this.username = username;
        this.registerBy = registerBy;
    }
    
    public User(int id, String username, String description,
            String location, String registerBy) {
        this(username, registerBy);
        this.id = id;
        this.description = description;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegisterBy() {
        return registerBy;
    }

    public void setRegisterBy(String registerBy) {
        this.registerBy = registerBy;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
    
    
}
