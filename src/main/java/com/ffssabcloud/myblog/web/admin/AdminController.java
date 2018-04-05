package com.ffssabcloud.myblog.web.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Meta;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.web.BaseController;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
    
    @Autowired
    SiteService siteService;
    
    @GetMapping(value = "")
    public String index() {
        return this.overview();
    }
    
    @GetMapping(value = "/overview")
    public String overview() {
        return "admin/index";
    }
    
    
    
    
}