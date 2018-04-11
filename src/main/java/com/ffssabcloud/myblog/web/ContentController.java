package com.ffssabcloud.myblog.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Archive;
import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.domain.Comment;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.exception.NotFoundException;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.ArticleService;
import com.ffssabcloud.myblog.service.CommentService;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.utils.DateUtils;

@Controller
public class ContentController extends BaseController{
    
    private static final Logger LOGGER = LogManager.getLogger(ContentController.class);
    @Autowired
    ArticleService articleService;
    
    @Autowired
    CommentService commentService;
    
    @Autowired
    SiteService siteService;
    
    @GetMapping(value = "/articles/{articleId}")
    public String getContent(HttpServletRequest request,
                                HttpServletResponse response,
                                HttpSession session,
                                @PathVariable int articleId) throws NotFoundException {
        Article article = articleService.getArticle(articleId);
        List<Comment> comments = commentService.getComments(article.getId());
        List<Archive> archives = siteService.getArchivesWithoutArticles();
        
        request.setAttribute("article", article);
        request.setAttribute("comments", comments);
        request.setAttribute("archives", archives);
        this.setTitle(request, article.getTitle());
        
        articleService.updateArticleClicks(articleId, article.getClicks());
        return "article";
    }
    
    @PostMapping(value = "/comment")
    @ResponseBody
    public RestResponseBo putComment(HttpServletRequest request,
                                        HttpServletResponse response,
                                        HttpSession session,
                                        @RequestParam int aid,
                                        @RequestParam String atitle,
                                        @RequestParam String rid,
                                        @RequestParam String r,
                                        @RequestParam String _csrf_token,
                                        @RequestParam String text) {

        String token = (String) session.getAttribute("_csrf_token");
        UserInfo userInfo = (UserInfo) session.getAttribute(Constrants.Web.SESSION_USERINFO_NAME);
        
        if(userInfo == null) {
            return RestResponseBo.fail("未登录!");
        }
        if(!StringUtils.isBlank(rid) && StringUtils.isBlank(r)) {
            return RestResponseBo.fail("参数数量错误!");
        }
        if(!_csrf_token.equals(token) || StringUtils.isBlank(_csrf_token)) {
            return RestResponseBo.fail("csrf错误!");
        }
        if(StringUtils.isBlank(text)) {
            return RestResponseBo.fail("内容不能为空!");
        }
        if(text.length() < 5) {
            return RestResponseBo.fail("内容过短!");
        }
        
        Comment comment = new Comment();
        comment.setArticleid(aid);
        comment.setArticletitle(atitle);
        comment.setAuthor(userInfo.getUser().getUsername());
        comment.setAuthorid(userInfo.getUser().getId());
        comment.setContent(text);
        comment.setCreateat(DateUtils.getUnixTime());
        
        if(!StringUtils.isBlank(rid)) {
            comment.setReplyid(Integer.parseInt(rid));
        }
        if(!StringUtils.isBlank(r)) {
            comment.setReply(r);
        }
        
        try {
            commentService.addComment(comment);
            articleService.addCommentNum(aid);
        } catch(Exception e) {
            LOGGER.error("fail to createComment: " + e.getMessage());
            return RestResponseBo.fail(e.getMessage());
        }
        
        return RestResponseBo.ok("提交成功!");
    }
                                    
}
