package com.ffssabcloud.forum.domain.DB1;

import com.ffssabcloud.forum.domain.User;

public interface UserRepository {
    public User findByUsername(String username);
    public void addAUser(User user);
    public Integer getCountOfUser();
}
