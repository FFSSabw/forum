package com.ffssabcloud.myblog.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ffssabcloud.myblog.domain.Article;


@Component
public interface PostRepository {
    public Article findByName(String name);
    public void addAPost(Article post);
    public Integer getCountOfPost();
}
