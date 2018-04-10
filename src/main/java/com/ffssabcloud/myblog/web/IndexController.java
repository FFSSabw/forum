package com.ffssabcloud.myblog.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Archive;
import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.service.ArticleService;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.utils.Commons;
import com.github.pagehelper.PageInfo;

@Controller
public class IndexController extends BaseController{
    
    @Autowired
    ArticleService articleService;
    
    @Autowired
    SiteService siteService;
    
    @GetMapping(value = "/")
    public String index(HttpServletRequest request,
                        HttpSession session,
                        @RequestParam(value = "limit", defaultValue = "12") int limit) {
        
        return this.index(request, session, 1, limit);
    }
    
    @GetMapping(value = "/page/{page}")
    public String index(HttpServletRequest request,
                        HttpSession session,
                        @PathVariable int page,
                        @RequestParam(value = "limit", defaultValue = "12") int limit) {
        
        page = page < 0 || page > Constrants.Web.MAX_PAGE ? 1 : page;
        PageInfo<Article> pageInfo = articleService.getArticles(page, limit);
        List<Archive> archives = siteService.getArchivesWithoutArticles();
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("pageUri", "/page/");
        request.setAttribute("archives", archives);
        this.setTitle(request, "第" + page + "页");
        
        return "index";                    
    }
    
    @GetMapping(value = "/categories/{keyword}")
    public String categories(HttpServletRequest request,
                                HttpSession session,
                                @PathVariable String keyword,
                                @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.categories(request, session, keyword, 1, limit);
    }
    
    @GetMapping(value = "/categories/{keyword}/{page}")
    public String categories(HttpServletRequest request,
                                HttpSession session,
                                @PathVariable String keyword,
                                @PathVariable int page,
                                @RequestParam(value = "limit", defaultValue = "12") int limit) {
        page = page < 0 || page > Constrants.Web.MAX_PAGE ? 1 : page;
        PageInfo<Article> pageInfo = articleService.getArticles(keyword, Constrants.Article.PUBLISHED, page, limit);
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("pageUri", "/categories/" + keyword + "/");
        
        return "index";
    }
    
    @GetMapping(value = "/archives")
    public String archtive(HttpServletRequest request) {
        List<Archive> archives = siteService.getArchives();
        request.setAttribute("archives", archives);
        
        return "archives";
    }
}
