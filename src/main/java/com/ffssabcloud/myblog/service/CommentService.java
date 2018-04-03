package com.ffssabcloud.myblog.service;

import java.util.List;

import com.ffssabcloud.myblog.domain.Comment;

public interface CommentService {
    public List<Comment> getComments(int articleId);
    public void addComment(Comment comment);
}
