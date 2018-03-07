package com.ffssabcloud.forum.domain.DB1;

import com.ffssabcloud.forum.domain.User;

public interface UserRepository {
    public User findByName(String name);
    public void addAUser(String name);
}
