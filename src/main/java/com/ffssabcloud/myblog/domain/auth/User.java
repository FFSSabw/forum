package com.ffssabcloud.myblog.domain.auth;

import java.io.Serializable;

public class User implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String description;

    private String location;

    private String registerby;

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
        this.username = username == null ? null : username.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getRegisterby() {
        return registerby;
    }

    public void setRegisterby(String registerby) {
        this.registerby = registerby == null ? null : registerby.trim();
    }
}