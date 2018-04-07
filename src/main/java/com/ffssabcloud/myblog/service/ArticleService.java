package com.ffssabcloud.myblog.service;

import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.exception.NotFoundException;
import com.ffssabcloud.myblog.exception.PromptException;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
    public PageInfo<Article> getArticles(int page, int limit);
    public Article getArticle(int id) throws PromptException;
    public void addCommentNum(int articleId, int num);
    public void addCommentNum(int articleId);
    public void updateArticleClicks(Integer articleId, Integer clicks);
    public void updateArticle(Article article);
    public PageInfo<Article> getArticles(String keyword, int page, int limit);
    public void deleteArticle(int articleId);
    public boolean checkExist(int articleId);
    public void addArticle(Article article);
}
