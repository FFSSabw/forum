package com.ffssabcloud.myblog.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.ArticleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/admin/articles")
public class ArticleController {
    
    @Autowired
    ArticleService articleService;
    
    @GetMapping(value = "")
    public String getArticles(HttpServletRequest request,
                                @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.getArticles(request, 1, limit);
    }
    
    @GetMapping(value = "/page/{page}")
    public String getArticles(HttpServletRequest request,
                                @PathVariable int page,
                                @RequestParam(value = "limit", defaultValue = "12") int limit) {

        page = page < 0 || page > Constrants.Web.MAX_PAGE ? 1 : page;
        PageInfo<Article> pageInfo = articleService.getArticles(page, limit);
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("pageUri", "/admin/articles/page/");
        
        return "admin/article_list";
    }
    
    @GetMapping(value = "/publish")
    public String getArticle(HttpServletRequest request) {
        
        return "admin/article_edit";
    }
    
    @PostMapping(value = "/publish")
    public String postArticle() {
        return "index";
    }
    
    @GetMapping(value = "/{articleId}")
    public String editArticle(@PathVariable int articleId) {
        return "admin/article_edit";
    }
    
    @PostMapping(value = "/modify")
    public RestResponseBo modifyArticle() {
        return RestResponseBo.ok();
    }
    
    @DeleteMapping(value = "/{aid}")
    @ResponseBody
    public RestResponseBo deleteArticle(@PathVariable int aid) {
        try {
            articleService.deleteArticle(aid);
        } catch(Exception e) {
            if(e instanceof PromptException) {
                return RestResponseBo.fail(e.getMessage());
            }
        }
        return RestResponseBo.ok();
    }
}
