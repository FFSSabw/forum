package com.ffssabcloud.myblog.service;

import java.util.List;

import com.ffssabcloud.myblog.domain.Comment;
import com.ffssabcloud.myblog.exception.NotFoundException;

public interface CommentService {
    public List<Comment> getComments();
    public List<Comment> getComments(int articleId);
    public void addComment(Comment comment);
    public void deleteComment(int commentId) throws NotFoundException;
}
