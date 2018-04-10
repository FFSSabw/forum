package com.ffssabcloud.myblog.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.domain.ArticleExample;
import com.ffssabcloud.myblog.domain.ArticleExample.Criteria;
import com.ffssabcloud.myblog.domain.dao.ArticleMapper;
import com.ffssabcloud.myblog.exception.NotFoundException;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleServiceImp implements ArticleService{
    
    @Autowired
    ArticleMapper articleMapper;
    
    @Override
    public PageInfo<Article> getArticles(int page, int limit) {
        return getArticles(null, Constrants.Article.PUBLISHED, page, limit);
    }
    
    @Override
    public PageInfo<Article> getArticles(Boolean status, int page, int limit) {
        return getArticles(null, status, page, limit);
    }
    
    @Override
    public PageInfo<Article> getArticles(String keyword, Boolean status, int page, int limit) {
        PageHelper.startPage(page, limit);
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("createAt desc");
        
        Criteria criteria = example.createCriteria();
        if(status != null) {
            criteria.andStatusEqualTo(status);
        }
        if(keyword != null) {
            criteria.andCategoriesEqualTo(keyword);
        }
        
        List<Article> articles = articleMapper.selectByExample(example);
        PageInfo<Article> pageInfo = new PageInfo<Article>(articles);
        
        return pageInfo;
    }
    
    @Override
    public Article getArticle(int id) throws PromptException {
        Article article = articleMapper.selectByPrimaryKey(id);
        
        if(article == null) {
            throw new PromptException("没有相应的文章");
        }
        if(article.getStatus().equals(Constrants.Article.UNPUBLISHED)) {
            throw new PromptException("文章未发布");
        }
        return article;
    }

    @Override
    @Async
    public void addCommentNum(int articleId, int num) {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        int comments = article.getComments();
        article.setComments(comments + num);
        articleMapper.updateByPrimaryKey(article);
        
    }

    @Override
    @Async
    public void addCommentNum(int articleId) {
        this.addCommentNum(articleId, 1);
        
    }

    @Override
    @Async
    public void updateArticleClicks(Integer articleId, Integer clicks) {
        Article temp = new Article();
        if(clicks == null) {
            clicks = 0;
        }
        temp.setId(articleId);
        temp.setClicks(clicks + 1);
        articleMapper.updateByPrimaryKeySelective(temp);
        
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }
    
    @Override
    public void deleteArticle(int articleId) {
        if(!checkExist(articleId)) {
            throw new PromptException("文章不存在!");
        }
        articleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public boolean checkExist(int articleId) {
        if(articleMapper.selectByPrimaryKey(articleId) == null) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void addArticle(Article article) {
        articleMapper.insert(article);
        
    }

}
