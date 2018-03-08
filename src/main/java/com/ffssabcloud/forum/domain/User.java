package com.ffssabcloud.forum.domain;

public class User {
    private Integer id;
    private Integer rid;
    private String username;
    private String password;
    private String email;
    private String description;
    private String location;
    
    public User() {}
    
    public User(Integer rid, String username,String password,
            String email) {
        this.rid = rid;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public User(Integer rid, String username,String password,
            String email, String location, String description) {
        this(rid, username, password, email);
        this.description = description;
        this.location = location;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getRid() {
        return rid;
    }
    
    public void setRid(Integer rid) {
        this.rid = rid;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    

}
