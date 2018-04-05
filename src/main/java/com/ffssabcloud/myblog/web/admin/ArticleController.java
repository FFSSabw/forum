package com.ffssabcloud.myblog.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.domain.Meta;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.ArticleService;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.utils.DateUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/admin")
public class ArticleController {
    
    @Autowired
    ArticleService articleService;
    
    @Autowired
    SiteService siteService;
    
    @GetMapping(value = "/articles")
    public String getArticles(HttpServletRequest request,
                                @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.getArticles(request, 1, limit);
    }
    
    @GetMapping(value = "/articles/page/{page}")
    public String getArticles(HttpServletRequest request,
                                @PathVariable int page,
                                @RequestParam(value = "limit", defaultValue = "12") int limit) {

        page = page < 0 || page > Constrants.Web.MAX_PAGE ? 1 : page;
        PageInfo<Article> pageInfo = articleService.getArticles(page, limit);
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("pageUri", "/admin/articles/page/");
        
        return "admin/article_list";
    }
    
    @GetMapping(value = "/article")
    public String getArticle(HttpServletRequest request) {
        request.setAttribute("uri", "/admin/article");
        return "admin/article_edit";
    }
    
    @PostMapping(value = "/article")
    @ResponseBody
    public RestResponseBo postArticle(HttpSession session,
                                            @RequestParam Integer aid,
                                            @RequestParam String title,
                                            @RequestParam String tags,
                                            @RequestParam String categories,
                                            @RequestParam boolean allowcomment,
                                            @RequestParam boolean publish,
                                            @RequestParam String description,
                                            @RequestParam String content,
                                            @RequestParam(value = "isModify", defaultValue = "false") boolean isModify) {
        UserInfo userInfo = (UserInfo) session.getAttribute(Constrants.Web.SESSION_USERINFO_NAME);
        
        if(StringUtils.isBlank(title)) {
            return RestResponseBo.fail("标题不能为空");
        }
        if(StringUtils.isBlank(categories)) {
            categories = "默认分组";
        }
        if(StringUtils.isBlank(content)) {
            return RestResponseBo.fail("内容不能为空");
        }
        
        Article article = new Article();
        if(isModify) {
            article.setId(aid);
        } else {
            article.setCreateat(DateUtils.getUnixTime());
            article.setAuthorid(userInfo.getUser().getId());
            article.setClicks(0);
            article.setComments(0);
        }
        article.setTitle(title);
        article.setTags(tags);
        article.setCategories(categories);
        article.setAllowcomment(allowcomment);
        article.setStatus(publish);
        article.setDescription(description);
        article.setContent(content);
        article.setModifyat(DateUtils.getUnixTime());  
        
        
        String[] tagsList = tags.split(",");
        
        try {
            if(isModify) {
                articleService.updateArticle(article);
            } else {
                articleService.addArticle(article);
            }
            
            siteService.setMetas(Constrants.Types.TAG, tagsList);
        } catch(Exception e) {
            e.printStackTrace();
            return RestResponseBo.fail("发生未知错误!");
        }
        
        return RestResponseBo.ok();
    }
    
    @GetMapping(value = "/articles/{articleId}")
    public String editArticle(HttpServletRequest request,
                                @PathVariable int articleId) {
        Article article = null;
        List<Meta> metas = null;
        
        try {
            article = articleService.getArticle(articleId);
            metas = siteService.getMetas(Constrants.Types.CATEGORIES);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        request.setAttribute("article", article);
        request.setAttribute("categories", metas);
        request.setAttribute("uri", "/admin/articles/" + articleId);
        
        return "admin/article_edit";
    }
    
    @PutMapping(value = "/articles/{articleId}")
    @ResponseBody
    public RestResponseBo editArticle(HttpSession session,
                                            @RequestParam Integer aid,
                                            @RequestParam String title,
                                            @RequestParam String tags,
                                            @RequestParam String categories,
                                            @RequestParam boolean allowcomment,
                                            @RequestParam boolean publish,
                                            @RequestParam String description,
                                            @RequestParam String content) {
        return this.postArticle(session, aid, title, tags, categories, allowcomment, publish, description, content, true);
    }
    
    @DeleteMapping(value = "/articles/{aid}")
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
