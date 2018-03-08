package com.ffssabcloud.forum.domain.DB2;

import com.ffssabcloud.forum.domain.Post;

public interface PostRepository {
    public Post findByName(String name);
    public void addAPost(Post post);
    public Integer getCountOfPost();
}
