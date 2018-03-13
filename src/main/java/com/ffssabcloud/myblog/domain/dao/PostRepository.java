package com.ffssabcloud.myblog.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ffssabcloud.myblog.domain.Post;

@Component
public interface PostRepository {
    public Post findByName(String name);
    public void addAPost(Post post);
    public Integer getCountOfPost();
}
