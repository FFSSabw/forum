package com.ffssabcloud.myblog.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.myblog.domain.Comment;
import com.ffssabcloud.myblog.domain.CommentExample;
import com.ffssabcloud.myblog.domain.dao.CommentMapper;
import com.ffssabcloud.myblog.service.ArticleService;
import com.ffssabcloud.myblog.service.CommentService;

@Service
public class CommentServiceImp implements CommentService{
    
    @Autowired
    CommentMapper commentMapper;
    
    @Override
    public List<Comment> getComments() {
        return commentMapper.selectByExample(new CommentExample());
    }
    
    @Override
    public List<Comment> getComments(int articleId) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("createAt desc");
        example.or().andArticleidEqualTo(articleId);
        List<Comment> comments = commentMapper.selectByExample(example);
        
        return comments;
    }

    @Override
    @Transactional
    public void addComment(Comment comment) {
        commentMapper.insert(comment);
    }

}
