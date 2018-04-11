package com.ffssabcloud.myblog.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.domain.Comment;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/admin/comments")
public class CommentController {
    
    private static final Logger LOGGER = LogManager.getLogger(CommentController.class);
    
    @Autowired
    CommentService commentService;
    
    @GetMapping(value = "")
    public String comments(HttpServletRequest request,
                            @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.comments(request, 1, limit);
    }
    
    @GetMapping(value = "/page/{page}")
    public String comments(HttpServletRequest request,
                            @PathVariable int page,
                            @RequestParam(value = "limit", defaultValue = "12") int limit) {
        PageHelper.startPage(page, limit);
        List<Comment> comments = commentService.getComments();
        
        request.setAttribute("pageInfo", new PageInfo<Comment>(comments));
        request.setAttribute("pageUri", "/admin/comments/page/");
        
        return "admin/comments_list";
    }
    
    @DeleteMapping(value = "/{cid}")
    @ResponseBody
    public RestResponseBo deleteComment(@PathVariable int cid) {
        try {
            commentService.deleteComment(cid);
        } catch(Exception e) {
            return RestResponseBo.fail(e.getMessage());
        }
        
        LOGGER.info("删除评论成功, 评论ID为: " + cid);
        
        return RestResponseBo.ok("删除成功!");
    }
}
