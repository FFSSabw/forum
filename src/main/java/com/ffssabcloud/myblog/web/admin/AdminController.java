package com.ffssabcloud.myblog.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Meta;
import com.ffssabcloud.myblog.domain.Option;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.modal.bo.RestResponseBo;
import com.ffssabcloud.myblog.service.IOptionService;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.utils.Commons;
import com.ffssabcloud.myblog.web.BaseController;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{
    
    @Autowired
    SiteService siteService;
    
    @Autowired
    IOptionService optionService;
    
    @GetMapping(value = "")
    public String index() {
        return this.overview();
    }
    
    @GetMapping(value = "/overview")
    public String overview() {
        return "admin/index";
    }
    
    @GetMapping(value = "/options")
    public String options() {
        return "admin/option";
    }
    
    @PutMapping(value = "/options")
    @ResponseBody
    public RestResponseBo options(HttpServletRequest request) {
        Map<String, String[]> querys = request.getParameterMap();
        HashMap<String, String> options = new HashMap<>();
        
        querys.forEach((key, value) -> {
            options.put(key, join(value));
        });
        
        try {
            optionService.saveOptions(options);
        } catch(Exception e) {
            return RestResponseBo.fail("修改失败!");
        }
        
        Commons.options = options;
        return RestResponseBo.ok("修改成功!");
    }
    
    private String join(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }
    
}
